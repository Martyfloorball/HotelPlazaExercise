//implement in staff

public class Employee{
   public String name;
   public String title;
   public int phoneNumber;
   protected double salary;
   protected int vacation;
   protected int workingHours;
   
   public Employee(){}
   
   public Employee(String name, String title, int phoneNumber, double salary, int vacation, int workingHours){
      this.name = name;
      this.title = title;
      this.phoneNumber = phoneNumber;
      this.salary = salary;
      this.vacation = vacation;
      this.workingHours = workingHours; 
   }
   
   public int getVacation(){ return 5; } 
   
   public double getSalary(){ return 250000; } 
   
   public int getWorkingHours(){ return 37; }  
   
   public String toString(){
      return "Name: "+name+"\nTitle: "+title+"\nPhone number: "+phoneNumber+"\nSalary: "
                  +salary+"\nVacation: "+vacation+" weeks.\nWorking hours: "+workingHours; 
   }
}