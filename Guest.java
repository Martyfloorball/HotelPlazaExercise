import java.util.*;
import java.io.*;

class Guest{
   //prvate fields
   private int guestID = 1; //starting ID
   private String firstName;
   private String lastName;
   private String addressRoad;
   private int addressNumber;
   private int phoneNumber;
   
   public Guest(){} //null constructor
   
   //constructor that accepts parameters
   public Guest(int guestID, String firstName, String lastName, String addressRoad, int addressNumber, int phoneNumber){
      this.guestID = guestID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.addressRoad = addressRoad;
      this.addressNumber = addressNumber;
      this.phoneNumber = phoneNumber;
   }
   //print to file without overriding the file
   public void saveFile(String fileName)throws Exception{
      PrintStream outputToFile = new PrintStream(new FileOutputStream(fileName, true));
      outputToFile.print(toString() + "\n");
   }
   public String toString(){
      return guestID + " " + firstName + " " + lastName + " " + addressRoad + " " + addressNumber + " " + phoneNumber;
   }
   public void createNewGuest(Scanner console)throws Exception{
      guestid(); //calls a method that sees what ID comes next
      System.out.println("Enter firstname of guest:");
      this.firstName = console.next();
      System.out.println("Enter lastname of guest:");
      this.lastName = console.next();
      System.out.println("Enter address (road name) of guest:");
      this.addressRoad = console.next();
      System.out.println("Enter address (road number) of guest:");
      this.addressNumber = console.nextInt();
      System.out.println("Enter phonenumber of guest:");
      this.phoneNumber = console.nextInt();
      saveFile("GuestList.txt");
   }
   //counts what guest ID is next 
   public int guestid()throws Exception{
      Scanner read = new Scanner(new File("GuestList.txt")); //read from file
      
      while(read.hasNextLine()){ //it has line
         this.guestID++; //increment this.guestID
         if (read.nextLine() == null) break; //to avoid infinity loop
      } 
      return this.guestID; //return the outcome
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
               System.out.println(entry[i]); //print the current array placeholder
            }
         }
      n++; //increment n that is used in the String array "entry"
      } 
   }
   //prints the guests
   public void printGuestList()throws Exception{
      Scanner guestList = new Scanner (new File("GuestList.txt"));
      while (guestList.hasNextLine()){ //while the fale has next line
         this.guestID = guestList.nextInt();
         this.firstName = guestList.next();
         this.lastName = guestList.next();
         this.addressRoad = guestList.next();
         this.addressNumber = guestList.nextInt();
         this.phoneNumber = guestList.nextInt();
         System.out.println(toString());
      }
   }
   
   /*
   changeGuest method see from staff class
   */
   
   //getters
   public int getGuestID(){ return guestID; }
   
   public String getFirstName(){ return firstName; }
   
   public String getLastName(){ return lastName; }
   
   public String getAddressRoad(){ return this.addressRoad; }
   
   public int getAddressNumber(){ return this.addressNumber; }
   
   public int getPhoneNumber(){ return phoneNumber; }
   
   //setters
   public void setGuestID(int guestID){ this.guestID = guestID; }
   
   public void setFirstName(String firstName){ this.firstName = firstName; }
   
   public void setLastName(String lastName){ this.lastName = lastName; }
   
   public void setAddressRoad(String addressRoad){ this.addressRoad = addressRoad; }
   
   public void setAddressNumber(int addressNumber){ this.addressNumber = addressNumber; }
   
   public void setPhoneNumber(int newPhoneNumber){ this.phoneNumber = newPhoneNumber; }
}