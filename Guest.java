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
      Scanner read = new Scanner(new File("GuestList.txt")); //read from file
      Scanner console = new Scanner(System.in); //user input
      String[] entry = new String[n]; //initialize String array of n 
   
      System.out.print("Please enter guest ID: ");
      int readGuest = console.nextInt(); //initialize int that takes in user input
   
      while (read.hasNextLine()){ //while the txt file has a line
         Scanner readLine = new Scanner(read.next()); //new scanner that reads the first tokens of the "read" Scanner
         for (int i = 0; i < entry.length; i++){ //loop the lenght of entry
            entry[i] = read.nextLine(); //save to array
            
           if(readLine.nextInt() == readGuest){ //if match print the line
               System.out.println(entry[i]);
            }
         }
      n++; //increment n that is used in the String array "entry"
      } 
   }
   public void printGuestList()throws Exception{
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
   }
   
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