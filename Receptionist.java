public class Receptionist extends Staff{
   public Receptionist(){}
   
   public Receptionist(int staffID, String title, String firstName, String lastName, int phoneNumber, double salary, int vacation, int workingHours){
      super(staffID, title, firstName, lastName, phoneNumber, salary, vacation, workingHours);
   }
   
   @Override 
   public int getVacation(){ return super.getVacation() + 1; }
   
   @Override
   public int getWorkingHours(){ return super.getWorkingHours() + 5; }
   
   public double getSalary(){ return super.getSalary(); } 
}
