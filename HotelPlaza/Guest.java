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
   public int counter; //for count() method 
   
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
         for (int i = 0; i < entry.length; i++){ //loop the length of entry
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
      while (guestList.hasNextLine()){ //while the file has next line
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
   /*
   This method is used in change guest.
   Its purpose is to count the lines.
   The counter is then used in the changeguest method
   to determen the placeholder lines in the array.
   */
   public int count()throws Exception{
      Scanner guestList = new Scanner(new File("GuestList.txt"));
      while(guestList.hasNextLine()){
         this.counter++; //increment
         if (guestList.nextLine() == null){ //no more lines break out
            break;
         } 
      }
      return this.counter;
   }
   public int changeGuest() throws Exception{
      Scanner consoleGuest = new Scanner(System.in); // user input
      Scanner fileGuestList = new Scanner(new File("GuestList.txt")); //read file
      count(); //run method to get count 
      String allGuest[][] = new String[this.counter][6]; //two dimentional array
      int guestMenuItem = -1; //a dummy to keep looping 
      
      //fill the placeholders in String array
      while(fileGuestList.hasNext()){
         for(int i = 0; i < this.counter; i++){
            for(int j = 0; j < 6; j++){
               String item = fileGuestList.next();
               allGuest[i][j] = item;
            } 
         }
         break;
      }  
      String guestid = new String(); //initialize new String 
      int i = 0;
      System.out.println("Enter guest ID to change");
      guestid = consoleGuest.next();
      
      while(guestMenuItem != 0){
         System.out.println("1. Change firstname:");
         System.out.println("2. Change lastname:");
         System.out.println("3. Change road name on address:");
         System.out.println("4. Change road number on address:");
         System.out.println("5. Change phonenumber:");
         System.out.println("0. Return to main menu:");    
         
         //see if the guest id is equal any of the other id's
         for(i = 0; i < this.counter; i++){
            String tmpGuestID = allGuest[i][0];
            if (guestid.equals(tmpGuestID)){ break; }//check id
         }
         break;  
      }
      
      guestMenuItem = consoleGuest.nextInt();//user input
      
      //the user case change whatever they what 
      switch(guestMenuItem){
         case 1:
            System.out.println("Enter new firstname");
            this.firstName = consoleGuest.next();
            allGuest[i][1] = this.firstName;
            break;
         
         case 2:
            System.out.println("Enter new lastname");
            this.lastName = consoleGuest.next();
            allGuest[i][2] = this.lastName;
            break; 
         
         case 3:
            System.out.println("Enter new road name");
            this.addressRoad = consoleGuest.next();
            allGuest[i][3] = this.addressRoad;
            break;
         
         case 4:
            System.out.println("Enter new road number:");
            this.addressNumber = consoleGuest.nextInt();
            //String is a class in a class called Number that is inherited from the Object class
            String addressNum = String.valueOf(this.addressNumber); //Returns the string representation of the primitive argument. 
            allGuest[i][4] = addressNum;
            break;
         
         case 5:
            System.out.println("Enter new phonenumber:");
            this.phoneNumber = consoleGuest.nextInt();
            String phoneNum = String.valueOf(this.phoneNumber); 
            allGuest[i][5] = phoneNum;         
            break;
         
         case 0: 
            break;
         
         default: System.out.println("Invalid entry, please enter number of the menu you want to access"); break;
      }
      //override the placeholder
      PrintStream addChange = new PrintStream(new File("GuestList.txt"));
      for (i = 0; i < this.counter; i++){
         addChange.println(allGuest[i][0] + " " + allGuest[i][1] + " " + allGuest[i][2] +
                        " " + allGuest[i][3] + " " + allGuest[i][4] + " " + allGuest[i][5]);
      }
      //clean-up
      fileGuestList.close(); //always close. If not the it will be locked for other process (it cannot be invoked)       
   return 0;
   }
   
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