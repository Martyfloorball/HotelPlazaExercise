import java.util.*;
import java.io.*;

class Staff{   
   private int staffID;
   private String title;
   private String firstName;
   private String lastName;
   private int phoneNumber;
   protected double salary;
   protected int vacation;
   protected int workingHours;
   
   //null constructor
   public Staff(){}
   
   //staff constructor with parameters
   public Staff(int staffID, String title, String firstName, String lastName, int phoneNumber, double salary, int vacation, int workingHours){
      this.staffID = staffID;
      this.title = title;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.salary = salary;
      this.vacation = vacation;
      this.workingHours = workingHours;
   }
   //print to file without overriding the file
   public void saveFile(String fileName)throws Exception{
      PrintStream outputToFile = new PrintStream(new FileOutputStream(fileName, true));
      outputToFile.print(toString() + "\n"); //print in the order of toString()
   }
      
   public String toString(){
      return staffID+" "+title+" "+firstName+" "+lastName+" "+phoneNumber+" "
                                                   +salary+" "+vacation+" "+workingHours; 
   }
   
   public void createNewStaff(Scanner console)throws Exception{
      //set staffID
      updateStaffID();
      
      //pick a title
      chooseTitle(console);
      System.out.println("Enter firstname of staffmember:");
      firstName = console.next();
      System.out.println("Enter lastname of staffmember:");
      lastName = console.next();
      System.out.println("Enter phonenumber of staffmember:");
      phoneNumber = console.nextInt();
      
      //save salary, vacation and workingHours
      seeTitle(title);      
      
      //save to the list
      saveFile("StaffList.txt"); 

    }
    public int updateStaffID()throws Exception{
      Scanner read = new Scanner(new File("StaffList.txt")); //read from file
      while(read.hasNextLine()){ //it has line
         this.staffID++; //increment this.staffID
         if (read.nextLine() == null) break; //to avoid infinity loop
      } 
      return this.staffID; //return the outcome
    }
   
    /*
    Lets the user choose what title he has.
    Then it initializes to value to the variable "title".
    */
    public String chooseTitle(Scanner console){
      System.out.print("Pick a title: \n1 = Director.\n2 = Accountant.\n3 = Maintenance.\n4 = Receptionist.\nEnter\t:\t");
      title = console.next();
      switch(title){
         case "1": 
            this.title = "Director";
            break;
         case "2":
            this.title = "Accountant";
            break;     
         case "3":
            this.title = "Maintenance";
            break;
         case "4":
            this.title = "Receptionist";
            break;
         default:
            System.out.println("You didn't choose a title.");
            chooseTitle(console);//loop menu   
      }
      System.out.println(); //skip line
      return title;
    }
    //See what title he got and then save info to the list (salary, vacation and working hours)
    public void seeTitle(String title){
      if(title.toLowerCase().equals("director")){ //takes the title and convert to all char to lower cases and sees if it's a match 
         Director d = new Director(); //initialize object 
         salary = d.getSalary(); //get salary
         vacation = d.getVacation(); //get vacation days
         workingHours = d.getWorkingHours(); //get hours he will be working
      }else if (title.toLowerCase().equals("accountant")){
         Accountant a = new Accountant();
         salary = a.getSalary(); 
         vacation = a.getVacation(); 
         workingHours = a.getWorkingHours();       
      }else if (title.toLowerCase().equals("maintenance")){
         Maintenance m = new Maintenance();
         salary = m.getSalary();
         vacation = m.getVacation();
         workingHours = m.getWorkingHours();
      }else if (title.toLowerCase().equals("receptionist")){
         Receptionist r = new Receptionist();
         salary = r.getSalary();
         vacation = r.getVacation();
         workingHours = r.getWorkingHours();
      }
    }
    
    //print the staff list
    public void printStaffList()throws Exception{
      Scanner staffList = new Scanner (new File("StaffList.txt"));
      while (staffList.hasNextLine()){
         System.out.println(staffList.nextLine()); //print the line
      }
      System.out.println(); //skip line
    }
    
    /*
    This method reads the pernonelle from the file, and lets the user change
    whatever they whant changed. 
    The emphasis is on the "title" because when the title has been chosen
    it will automatically update salary, vacation weeks and working hours
    for the specific title. 
    */
    public int showStaffMenu() throws Exception{
      Scanner consoleStaff = new Scanner(System.in);
      String allStaff[][] = new String[4][8]; //initilize a two dimentional array 
      int staffMenuItem = -1; //a dummy to loop the menu until the sentinal is chosen
      String Item = null; //initialize a String variable
      Scanner fileStaffList = new Scanner(new File("StaffList.txt")); //scan file
      while (fileStaffList.hasNext()){ //has a line
         for (int i = 0; i < 4; i++){ //there are 4 horzontal lines in array
            for (int j = 0; j < 8; j++){ // there are 8 columns in array 
               Item = fileStaffList.next(); 
                  allStaff[i][j] = Item; //puts token in placeholder in array
            } 
         }
      }
      String staffid = new String(); //make new String object
      int i = 0;
      System.out.println("Enter staff ID to change");
      staffid = consoleStaff.next();
      while (staffMenuItem != 0){
         System.out.println("1. Change title:");
         System.out.println("2. Change firstname:");
         System.out.println("3. Change lastname:");
         System.out.println("4. Change phone number:");
         System.out.println("0. Return to main menu");
         
         //for loop check to see if staffID is the same as someone in file 
         for (i = 0; i < 4; i++){
            String tmpstaffid = allStaff[i][0];
            if (staffid.equals(tmpstaffid)){
               break;
            }
         }
         fileStaffList.close(); //always close. If not the it will be locked for other process (it cannot be invoked)  
         staffMenuItem = consoleStaff.nextInt(); //make referrence to variable 
         switch(staffMenuItem){//
            case 1:              
               System.out.println("Enter new title:");              
               allStaff[i][1] = chooseTitle(consoleStaff); //let user choose what title
               
               /*
               get values and automatically place them in specific places in array
               */
               
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
   //getters
   public int getStaffID() { return staffID; }
   
   public String getTitle() { return title; }
   
   public String getFirstName() { return firstName; }
   
   public String getLastName() { return lastName; }
   
   public int getPhoneNumber() { return phoneNumber; }
   
   public int getVacation(){ return 5; } 
   
   public double getSalary(){ return 250000; } 
   
   public int getWorkingHours(){ return 37; }
   
   //setters
   public void setStaffID(int staffID){ this.staffID = staffID; }
   
   public void setTitle(String title){ this.title = title; }
   
   public void setFirstName(String firstName){ this.firstName = firstName; }
   
   public void setLastName(String lastName){ this.lastName = lastName; }
   
   public void setPhoneNumber(int phoneNumber){ this.phoneNumber = phoneNumber; }
   
   public void setSalary(double salary){ this.salary = salary; }
   
   public void setVacation(int vacation){ this.vacation = vacation; }
   
   public void setWorkingHours(int workingHours){ this.workingHours = workingHours; }
    
}