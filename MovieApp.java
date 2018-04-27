import java.util.*;
import java.io.*;
import java.lang.*;

public class MovieApp {

   //User array 
   private User[] users = new User[100];
   //Scanner
   private Scanner input;
   Scanner scan = new Scanner(System.in);
   //Movie
   Movies m = new Movies();
   //Users
   int numberOfUsers = 0;
   User k = new User();
   User[] u = getUser();
   ArrayList<String> au = new ArrayList<String>();
   public User[] getUser(){
   
      return users;
   }
//App method  
  public void movieApp() throws FileNotFoundException{
  
      m.movieFile();
      createUsers(u);
      outerloop:
//App loop
      while(true){
      String n = "";
      int hej = 0;
      boolean menu1 = true;
      boolean menu2 = true;
   //Menu 1
         
         while(menu1){
            
            System.out.println();
            menu1(); 
            while(!scan.hasNextInt()){
               scan.next();
               System.out.println("AntiJarl!");
            }
            int valg = scan.nextInt();
            if(valg >= 0 && valg > 4){
         
               System.out.println("\nError, please enter 1 or 2.\n");
      //Log in 
            }else if(valg == 1){
               
               System.out.println("Please enter your password");
               String pass = scan.next();
               if(numberOfUsers == 0){
               
                  System.err.println("Account number not found.\n");
               }else{
               
                  boolean found = false;
                  for(int i = 0; i < numberOfUsers; i++){
                  
                     Account temp = u[i].getAccount();
                     String passTemp = temp.getPassword();
                     if(passTemp.equals(pass)){
                     
                        System.out.println();
                        n = u[i].getName();
                        System.out.println();
                        hej = i;
                        found = true;
                        menu1 = false;
                     }
                  }
                  if(found == false){
                  
                     System.err.println("Account number not found.\n");
                  }

            }
      //Create new user          
            }else if(valg == 2){
               System.out.println("Creating a new account\n");
               System.out.print("Please enter your name: ");
               String name = scan.next();
               au.add(name);
               System.out.println();
               
               System.out.print("Please enter your e-mail: ");
               String email = scan.next();
               au.add(email);
               System.out.println();
               
               System.out.print("Please enter your Password: ");
               String acc = scan.next();
               au.add(acc);
               System.out.println();
               System.out.println(au);
               
               Account account = new Account(acc);
               User user = new User(name, email, account);
               u[numberOfUsers] = user;
               
               System.out.println("Your account was succesfully made!");
               System.out.println("\nYour personal informations is:\n");
               u[numberOfUsers].displayUser();
               
               System.out.println("Password:\t" + acc);
               
               numberOfUsers++;
               System.out.println();

            }else if (valg == 0){
               saveUsers(au);
               break outerloop;
            }else if (valg == 3){
               System.out.print("Owner code: ");
               int code = scan.nextInt();
               if(code == 888){
                  System.out.println("What to do? ");
                  menu3(); 
                  int l = scan.nextInt(); 
                  if(l == 1){
                  
                     m.addMovie();
                     
                  }else if(l == 2){
                  
                     System.out.println("Which movie do you want to delete? ");
                     m.getMovies();
                     int o = scan.nextInt();
                     m.removeMovie(o);
                  }else{
                  
                     System.out.println("You have entered a wrong number");
                  }
               }else{
                  System.out.println("You have entered a wrong number");
               }       
            }
   
         }
         
   //Menu 2
         innerloop:
         while(menu2){
            
            System.out.println();
            System.out.println("Hej " + n +"!");
            menu2();
            int valg = scan.nextInt();
            switch(valg){
            
               case 0:
                  saveUsers(au);
                  break outerloop;
               case 1:
                     System.out.print("Which movie would you like to see? ");
                     System.out.println();
              
                     m.getMovies();
                     int v = scan.nextInt();
                     m.displayMovie(v);
                  break;
                  
               case 2:
               ArrayList<String> hist = new ArrayList<String>();
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


                  System.out.println("Your favorite list is: ");
                  u[hej].getFav();
                  System.out.println();
                  System.out.print("Would you like to add a movie to your favorites? yes=1   no=2 ");
                  int x = scan.nextInt();
                  if(x == 1){ 
                  
                     m.getMovies();
                     int choose = scan.nextInt();
                     
                     u[hej].setFav(m.movie.get(choose).getTitle());
                     System.out.println("Your favorite list is now: ");
                     u[hej].getFav();
                     System.out.println();
                     output.println(m.movie.get(choose).getTitle() + " was added to favorite list on: april 30.2018");
                  }else if(x != 2){
                  
                     System.out.println("You have entered a wrong code!"); 
                  }   
                  break;
                  
               case 3:
                  m.searchMovie();
                  break;
                  
               case 4:
                  
                  m.yourHistory();   
                  break;
               case 5:
                  System.out.println("Are you sure? yes=1   no=2");
                  int sure = scan.nextInt();
                  if(sure == 1){
                     System.out.println();
                     menu2 = false;
                  }else if(sure == 2){
                  
                  }
                  break;
            }
         }

      }
   }
//Menu 1  
   public void menu1(){
   
      System.out.println("\nWelcome to PogChamp Movies!");
      System.out.println("1. Log in");
      System.out.println("2. Create new account");
      System.out.println();
      System.out.println("3. Owner only");

   }
//Menu 2   
   public void menu2(){
   
      System.out.println("1. Watch Movie.");
      System.out.println("2. Add movie to \"favourite\".");
      System.out.println("3. Search for movie.");
      System.out.println("4. Your history."); 
      System.out.println("5. Log out.");
   }
//Menu 3  
   public void menu3(){
   
      System.out.println("1. Create movie.");
      System.out.println("2. Delete movie");
       
   }
   
   public void movieNames(){
   
      System.out.println("Which movie do you want to add? ");
      System.out.println("0. Matrix");
      System.out.println("1. Troja");
      System.out.println("2. Pirates of the Caribbean - Dead mans chest");
      System.out.println("3. StarWars");
      System.out.println("4. Lord of the Rings - Fellowship of the Ring");
   }
   
   public void saveUsers(ArrayList<String> au) throws FileNotFoundException{
   
      PrintStream output = new PrintStream(new File("Users.txt"));
      int i = 0;
      while(i < au.size()){
         output.print(au.get(i));
         output.println();
         i++;
      }    
   }  
   
   public void createUsers(User[] u) throws FileNotFoundException{
         
         Scanner m = new Scanner(new File("Users.txt"));
         numberOfUsers = 0;
         if(m.hasNextLine()){
            while(m.hasNextLine()){
            //Læs Filen
            String name = m.nextLine();
            au.add(name);
            String email = m.nextLine();
            au.add(email);
            String acc = m.nextLine();
            au.add(acc);
            //Lav users ud af det
            Account account = new Account(acc);
            User user = new User(name, email, account);
            
            u[numberOfUsers] = user;
                     
            numberOfUsers++;
            System.out.println();
         }
      }
      
   }

}