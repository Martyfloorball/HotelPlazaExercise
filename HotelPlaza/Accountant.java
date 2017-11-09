public class Accountant extends Staff{
   public Accountant(){}
   
   public Accountant(int staffID, String title, String firstName, String lastName, int phoneNumber, double salary, int vacation, int workingHours){
      super(staffID, title, firstName, lastName, phoneNumber, salary, vacation, workingHours);
   }
   
   @Override 
   public int getVacation(){
      return super.getVacation() + 1;
   }
   @Override
   public double getSalary(){
      return super.getSalary() + 200000;
   }
   public int getWorkingHours(){ return super.getWorkingHours();}
   
}