public class Maintenance extends Staff{
   public Maintenance(){}
   
   public Maintenance(int staffID, String title, String firstName, String lastName, int phoneNumber, double salary, int vacation, int workingHours){
      super(staffID, title, firstName, lastName, phoneNumber, salary, vacation, workingHours);
   }
  
   @Override
   public int getVacation(){ return super.getVacation() + 2; }
   
   public int getWorkingHours(){ return super.getWorkingHours();}
   
   public double getSalary(){ return super.getSalary(); }
}