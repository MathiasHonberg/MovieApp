import java.util.*;
import java.io.*;

public class User{

   private String name;
   private String email;
   private Account account;
   private ArrayList<String> fav = new ArrayList<String>();
   Movies m = new Movies();
   
   public User(String name, String email, Account account){
   
      this.name = name;
      this.email = email;
      this.account = account;
   
   }
   
   public User(){
   
   }
   
   public User(ArrayList<String> fav){
   
      this.fav = fav;
   }
   
   public String getName(){
   
      return this.name;
   }
   
   public String getEmail(){
   
      return this.email;
   }
   
   public Account getAccount(){
   
      return this.account;
   }
   
   public void setName(String name){
   
      this.name = name;
   }
   
   public void setEmail(String email){
   
      this.email = email;
   }
   
   public void displayUser(){
   
      System.out.println("Name:\t\t\t" + name);
      System.out.println("Email:\t\t" + getEmail());
   
   }
   
   public void setFav(String f){
   
      fav.add(f);
   }
   
   public void getFav(){
   
      for(String s : fav){
      
         System.out.println(s + " ");
      }
   }
      
}