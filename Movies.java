import java.util.*;
import java.io.*;

public class Movies{

   private String title;
   private String genre;
   private String pY;
   private String actor1; 
   private String actor2;
   private String actor3;
   
   ArrayList<Movies> movie = new ArrayList<Movies>();


   public Movies(String title, String genre, String pY, String actor1, String actor2, String actor3){
   
      this.title = title;
      this.genre = genre;
      this.pY = pY;
      this.actor1 = actor1;
      this.actor2 = actor2;
      this.actor3 = actor3;
   } 
   
   public Movies(){
   
   
   }
   public Movies(String title, String genre, String pY){
   
      this.title = title;
      this.genre = genre;
      this.pY = pY;
   }
   public Movies(String title, String genre, String pY, String actor1){
   
      this.title = title;
      this.genre = genre;
      this.pY = pY;
      this.actor1 = actor1;
   }

   
   public void setTitle(String title){
   
      this.title = title;
   }
   
   public void setGenre(String Genre){
   
      this.genre = genre;
   }

   public void setPy(String pY){
   
      this.pY = pY;
   }
   
   public String getTitle(){
   
      return this.title;
   }
   
   public String getGenre(){
   
      return this.genre;
   }
   
   public String getPy(){
   
      return this.pY;
   } 
   
    public String getActor1(){
   
      return this.actor1;
   } 
   
    public String getActor2(){
   
      return this.actor2;
   }
   
    public String getActor3(){
   
      return this.actor3;
   } 

   public void movieFile() throws FileNotFoundException{
      Scanner m = new Scanner(new File("Movies.txt"));
      
      int i = 0;
      while(m.hasNextLine()){
         String title = m.nextLine();
         String genre = m.nextLine();
         String pY = m.nextLine();
         String actor1 = m.nextLine();
         String actor2 = m.nextLine();
         String actor3 = m.nextLine();
         movie.add(i, new Movies(title, genre, pY, actor1, actor2, actor3));
         
         i++;
         
      }
  
   }
   
   public void getMovies(){
      
      int i = 0;
      while(i < movie.size()){
         System.out.println(i + ". " + movie.get(i));
        i++;
      }
      System.out.println();
   }
         
 ArrayList<String> hist = new ArrayList<String>();
      
      
   
   public void displayMovie(int target) throws FileNotFoundException{
   
    //  ArrayList<String> hist = new ArrayList<String>();
      
      File f = new File("history.txt");
      Scanner input = new Scanner(f);
      
      String text = "";
      
      
      while (input.hasNextLine()){
         text = input.nextLine();
         hist.add(text);
      }
      
      PrintStream output = new PrintStream (new File ("history.txt"));
      
      for (int i = 0; i < hist.size(); i++){
         output.println(hist.get(i));
      }
      
      System.out.println("\nTitle:\n\t" + movie.get(target).getTitle());
      System.out.println("\nGenre:\n\t" + movie.get(target).getGenre());
      System.out.println("\nProduction year:\n\t" + movie.get(target).getPy());
      System.out.println("\nActors:\n\t" + movie.get(target).getActor1());
      System.out.println("\t" + movie.get(target).getActor2());
      System.out.println("\t" + movie.get(target).getActor3());
      System.out.println();
      
      output.println(movie.get(target).getTitle() + ", was played on: april 30.2018");
      
      
   }
   
   
   public void addMovie()throws FileNotFoundException{
   
       File f = new File("history.txt");
      Scanner input = new Scanner(f);
      
      String text = "";
      
      
      while (input.hasNextLine()){
         text = input.nextLine();
         hist.add(text);
      }
      
      PrintStream output = new PrintStream (new File ("history.txt"));
      
      for (int i = 0; i < hist.size(); i++){
         output.println(hist.get(i));
      }

   
      Scanner m = new Scanner(System.in);
      System.out.print("Movie title: ");
      String title = m.nextLine();
      System.out.print("Movie genre: ");
      String genre = m.nextLine();
      System.out.print("Movie production year: ");
      String pY = m.nextLine();
      System.out.print("Movie actor: ");
      String actor1 = m.nextLine();
      System.out.print("Movie actor: ");
      String actor2 = m.nextLine();
      System.out.print("Movie actor: ");
      String actor3 = m.nextLine();
      Movies mov = new Movies(title, genre, pY, actor1, actor2, actor3);
      movie.add(mov);
      System.out.println();
      System.out.println("The new film was added: ");
      System.out.println("Title:\n\t" + title);
      System.out.println("Genre:\n\t" + genre);
      System.out.println("Production year:\n\t" + pY);
      System.out.println("Actor:\n\t" + actor1);
      System.out.print("\t" + actor2);
      System.out.print("\n\t" + actor3);
      
      output.println(title + ", was added to the movie lists by owner on: april 30.2018");
      
     
   }
   
   public String toString(){
      String text = "";
      text = text + "" + title;
      /*text = text + "\nGenre:\n\t" + genre;
      text = text + "\nProduction year:\n\t" + pY;
      text = text + "\nActors:\n\t" + actor1;
      text = text + "\n\t" + actor2;
      text = text + "\n\t" + actor3;*/
      
      return text;
   }
   
   public void removeMovie(int target)throws FileNotFoundException{
   
       File f = new File("history.txt");
      Scanner input = new Scanner(f);
      
      String text = "";
      
      
      while (input.hasNextLine()){
         text = input.nextLine();
         hist.add(text);
      }
      
      PrintStream output = new PrintStream (new File ("history.txt"));
      
      for (int i = 0; i < hist.size(); i++){
         output.println(hist.get(i));
      }

   
      System.out.println("The movie " + movie.get((target)).getTitle() + "was deleted");
      movie.remove((target));
      
      output.println(movie.get((target)).getTitle() + " was deleted on: april 30.2018");
   }
   
   public void searchMovie()throws FileNotFoundException{
      
      Scanner s = new Scanner(System.in);
  
      System.out.print("Search for movie title: ");
      String title = s.nextLine();
      for(int i = 0; i < movie.size(); i++){
      
         if(movie.get(i).getTitle().equals(title)){
         
            displayMovie(i);
            break;
         }
         
          
         
      } 
      System.out.println();
      System.out.println("Movie with title: " + title + ", was not found");
   }
   
   public void yourHistory () throws FileNotFoundException{
   
      File f = new File("history.txt");
      Scanner input = new Scanner(f);
      
      String text = "";
      
      while (input.hasNextLine()){
      
         text = input.nextLine();
         
         System.out.print(text + "\n");
      }
   }


}