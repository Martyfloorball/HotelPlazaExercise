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
   
   public Staff(){}
   
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
      return staffID+" "+title+" "+firstName+" "+lastName+" "+title+" "+phoneNumber+" "
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
    public int showStaffMenu() throws Exception{
      Scanner consoleStaff = new Scanner(System.in);
      String allStaff[][] = new String[4][6];
      int staffMenuItem = -1;
      String Item;
      Scanner fileStaffList = new Scanner(new File("StaffList.txt"));
      while (fileStaffList.hasNext()){
         for (int i = 0; i < 4; i++){
            for (int j = 0; j < 6; j++){
               Item = fileStaffList.next();
                  allStaff[i][j] = Item;
                  //TEST: System.out.println(Item);
            } 
         }
      }
   for (int i = 0; i < 4; i++){
      for (int j = 0; j < 6; j++){
         //TEST:System.out.println(allStaff[i][j]);
      }
   }
   String staffid = new String();
   int i = 0;
   System.out.println("Enter staff ID to change");
   staffid = consoleStaff.next();
   while (staffMenuItem != 0){
      System.out.println("1. Change title:");
      System.out.println("2. Change lastname:");
      System.out.println("3. Change phone number:");
      System.out.println("4. Change salary:");
      System.out.println("0. Return to main menu");
   
   for (i = 0; i < 4; i++){
            String tmpstaffid = allStaff[i][0];
         // TEST: System.out.print(tmpstaffid);
            if (staffid.equals(tmpstaffid)){
               break;
            }
         }
         fileStaffList.close();
          // TEST: System.out.print(i);
         staffMenuItem = consoleStaff.nextInt();
         switch(staffMenuItem){
            case 1:
               System.out.println("Enter new title:");
               title = consoleStaff.next();
               allStaff[i][1] = title;
            break;
            
            case 2:
               System.out.println("Enter new lastname:");
               lastName = consoleStaff.next();
               allStaff[i][3] = lastName;
            break;
            
            case 3:
               System.out.println("Enter new phone number:");
               int phoneNumber = consoleStaff.nextInt();
               String phoneNum = String.valueOf(phoneNumber);
               allStaff[i][4] = phoneNum;
            break;
            
            case 4:
               System.out.println("Enter new salary:");
               double salary = consoleStaff.nextDouble();
               String newsalary = String.valueOf(salary);
               allStaff[i][5] = newsalary;
            break;
            
            case 0:
               break;
               
            default: System.out.println("Invalid entry, please enter number of the menu you want to access");
   }
   PrintStream addChange = new PrintStream(new File("StaffList.txt"));
   for (i = 0; i < 4; i++){
      addChange.println(allStaff[i][0] + " " + allStaff[i][1] + " " + allStaff[i][2] + " " + allStaff[i][3] + " " + allStaff[i][4] + " " + allStaff[i][5]);
   }
   }    
   return 0;
}  
   //getters
   public int getVacation(){ return 5; } 
   
   public double getSalary(){ return 250000; } 
   
   public int getWorkingHours(){ return 37; }
   
   //setters
   
}