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
   public int changeGuest() throws Exception{
      Scanner consoleGuest = new Scanner(System.in);
      Scanner guestList = new Scanner (new File("GuestList.txt"));
      int n = 0;
      while (guestList.hasNextLine()){ n++; } //increment
      String allGuest[][] = new String[n][6]; //two dimentional array
      int guestMenuItem = -1;
      String item = null;
      
      while(guestList.hasNext()){
         for(int i = 0; i < n; i++){
            for(int j = 0; j < 6; j++){
               item = guestList.next();
               allGuest[i][j] = item;
            } 
         }
      }  
      String guestid = new String();
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
      }
      for(i = 0; i < n; i++){
         String tmpGuestID = allGuest[i][0];
         if (guestid.equals(tmpGuestID)){ break; }
      }
      guestList.close();
      guestMenuItem = consoleGuest.nextInt();
       
   return 0;
   }
   /*
         switch(staffMenuItem){//
            case 1:              
               System.out.println("Enter new title:");              
               allStaff[i][1] = chooseTitle(consoleStaff); //let user choose what title
               
               /*
               get values and automatically place them in specific places in array
               */
               /*
               if(title.toLowerCase().equals("director")){ //takes the title and convert to all char to lower cases and sees if it's a match 
                  Director d = new Director(); //initialize object 
                  this.salary = d.getSalary(); 
                  String sal = String.valueOf(this.salary); ////Returns the string representation of the primitive argument. 
                  allStaff[i][5] = sal;//replace placeholder with new information                  
                  this.vacation = d.getVacation(); 
                  String vaca = String.valueOf(this.vacation);
                  allStaff[i][6] = vaca;
                  this.workingHours = d.getWorkingHours(); 
                  String workH = String.valueOf(this.workingHours);
                  allStaff[i][7] = workH;
                  
               }else if (title.toLowerCase().equals("accountant")){
                  Accountant a = new Accountant();
                  this.salary = a.getSalary();
                  String sal = String.valueOf(this.salary);
                  allStaff[i][5] = sal; 
                  this.vacation = a.getVacation();
                  String vaca = String.valueOf(this.vacation);
                  allStaff[i][6] = vaca;                   
                  int workingHours = a.getWorkingHours();     
                  String workH = String.valueOf(this.workingHours);
                  allStaff[i][7] = workH; 
                   
               }else if (title.toLowerCase().equals("maintenance")){
                  Maintenance m = new Maintenance();
                  this.salary = m.getSalary();
                  String sal = String.valueOf(this.salary);
                  allStaff[i][5] = sal;
                  this.vacation = m.getVacation();
                  String vaca = String.valueOf(this.vacation);
                  allStaff[i][6] = vaca;                  
                  this.workingHours = m.getWorkingHours();
                  String workH = String.valueOf(this.workingHours);
                  allStaff[i][7] = workH;
                  
               }else if (title.toLowerCase().equals("receptionist")){
                  Receptionist r = new Receptionist();
                  this.salary = r.getSalary();
                  String sal = String.valueOf(this.salary);
                  allStaff[i][5] = sal;
                  this.vacation = r.getVacation();
                  String vaca = String.valueOf(this.vacation);
                  allStaff[i][6] = vaca;
                  this.workingHours = r.getWorkingHours(); 
                  String workH = String.valueOf(this.workingHours);
                  allStaff[i][7] = workH;
               }                     
            break; //break the case so it doesn't run case 2 with it 
            
            case 2:
               System.out.println("Enter new firstname:");
               this.firstName = consoleStaff.next();
               allStaff[i][2] = this.firstName;
            break;
            
            case 3:
               System.out.println("Enter new lastname:");
               this.lastName = consoleStaff.next();
               allStaff[i][3] = this.lastName;
            break;
            
            case 4:
               System.out.println("Enter new phone number:");
               this.phoneNumber = consoleStaff.nextInt(); 
               String phoneNum = String.valueOf(this.phoneNumber); //Returns the string representation of the primitive argument. 
               allStaff[i][4] = phoneNum;
            break;
       
            case 0:
               break;
               
            default: System.out.println("Invalid entry, please enter number of the menu you want to access");
      }
         //override the placeholder
         PrintStream addChange = new PrintStream(new File("StaffList.txt"));
         for (i = 0; i < 4; i++){
            addChange.println(allStaff[i][0] + " " + allStaff[i][1] + " " + allStaff[i][2] + " " + allStaff[i][3] + " " + allStaff[i][4] + " " + allStaff[i][5]+ " " + allStaff[i][6]+ " " + allStaff[i][7]);
         }
      }    
      return 0;
   }  
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