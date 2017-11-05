import java.util.*;
import java.io.*;

class Guest{
   private int guestID;
   private String firstName;
   private String lastName;
   private String adressRoad;
   private int adressNumber;
   private int phoneNumber;
   
   public Guest(){
   }
   
   public Guest(int guestID, String firstName, String lastName, String adressRoad, int adressNumber, int phoneNumber){
      this.guestID = guestID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.adressRoad = adressRoad;
      this.adressNumber = adressNumber;
      this.phoneNumber = phoneNumber;
   }
   public void saveFile(String fileName)throws Exception{
      PrintStream outputToFile = new PrintStream(new FileOutputStream(fileName, true));
      outputToFile.print(toString() + "\n\n");
   }
   public String toString(){
      return guestID + " " + firstName + " " + lastName + " " + adressRoad + " " + adressNumber + " " + phoneNumber;
   }
   public void createNewGuest(Scanner console)throws Exception{
      System.out.println("Pick a new guest ID:");
      guestID = console.nextInt();
      System.out.println("Enter firstname of guest:");
      firstName = console.next();
      System.out.println("Enter lastname of guest:");
      lastName = console.next();
      System.out.println("Enter adress (road name) of guest:");
      adressRoad = console.next();
      System.out.println("Enter adress (road number) of guest:");
      adressNumber = console.nextInt();
      System.out.println("Enter phonenumber of guest:");
      phoneNumber = console.nextInt();
      saveFile("GuestList.txt");
   }
   public void readGuestList()throws Exception{
      int n = 1;
      Scanner read = new Scanner(new File("GuestList.txt"));
      Scanner console = new Scanner(System.in);
      String[] entry = new String[n];
      System.out.print("Please enter guest ID: ");
      int readGuest = console.nextInt();
      while (read.hasNextLine()){
         for (int i = 0; i < entry.length; i++){
            if (read.hasNextLine()){
               entry[i] = read.nextLine();
            }
            if(read.nextInt() == readGuest){
               System.out.println(entry[i]);
            }
         }
     
         
      }
      //System.out.println(entry[readGuest]); 
      
      /* her kan bruges while loop samt to scanner (1 til nextLine og 1 til int token)*/
      
   }
   /*void printGuestList()throws Exception{
      Scanner guestList = new Scanner (new File("GuestList.txt"));
      while (guestList.hasNextLine()){
         guestID = guestList.nextInt();
         firstName = guestList.next();
         lastName = guestList.next();
         adressRoad = guestList.next();
         adressNumber = guestList.nextInt();
         phoneNumber = guestList.nextInt();
         System.out.println(toString());
      }
   }*/
   
   /*public int getGuestID(){
      return guestID;
   }
   public String getFirstName(){
      return firstName;
   }
   public String getLastName(){
      return lastName;
   }
   public String getAdress(){
      return adress;
   }
   public int getPhoneNumber(){
      return phoneNumber;
   }
   public void setGuestID(int newGuestID){
   guestID = newGuestID;
   }
   public void setFirstName(String newFirstName){
   firstName = newFirstName;
   }
   public void setLastName(String newLastName){
   lastName = newLastName;
   }
   public void setAdress(String newAdress){
   adress = newAdress;
   }
   public void setPhoneNumber(int newPhoneNumber){
   phoneNumber = newPhoneNumber;
   }*/
   
}