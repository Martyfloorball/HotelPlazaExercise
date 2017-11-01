import java.util.*;
import java.io.*;

class Staff{
   
   private int StaffID;
   private String title;
   private String firstName;
   private String lastName;
   private int phoneNumber;
   private double Salary;
   
   public Staff(){
   }
   
   public Staff(int StaffID, String title, String firstName, String lastName, int phoneNumber, double Salary){
      this.StaffID = StaffID;
      this.title = title;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.Salary = Salary;
   }
   public void saveFile(String fileName)throws Exception{
      PrintStream outputToFile = new PrintStream(new FileOutputStream(fileName, true));
      outputToFile.print(toString() + "\r\n\n");
   }
   public String toString(){
      return StaffID + " " + title + " " + firstName + " " + lastName + " " + phoneNumber + " " + Salary;
   }
   
   void createNewStaff(Scanner console)throws Exception{
      System.out.println("Pick a new staff ID number:");
      StaffID = console.nextInt();
      System.out.println("Pick a title:");
      title = console.next();
      System.out.println("Enter firstname of staffmember:");
      firstName = console.next();
      System.out.println("Enter lastname of staffmember:");
      lastName = console.next();
      System.out.println("Enter phonenumber of staffmember:");
      phoneNumber = console.nextInt();
      System.out.println("Enter salary of staffmember:");
      Salary = console.nextDouble();
      saveFile("StaffList.txt");

   }
   
   public void printStaffList()throws Exception{
      Scanner staffList = new Scanner (new File("StaffList.txt"));
      while (staffList.hasNextLine()){
         System.out.println(staffList.nextLine());
      }
   }    
}