public class Director extends Staff{
   public Director(){}
   
   public Director(int staffID, String title, String firstName, String lastName, int phoneNumber, double salary, int vacation, int workingHours){
      super(staffID, title, firstName, lastName, phoneNumber, salary, vacation, workingHours);
   }
   @Override 
   public int getWorkingHours(){
      return super.getWorkingHours() + 17;
   }
   @Override
   public double getSalary(){
      return super.getSalary() + 350000;
   }
}