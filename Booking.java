import java.io.*;
import java.util.*;

public class Booking {
    //fields
    public String startDate;
    public String endDate;
    public int numberOfDays;
    public String roomID;
    public int guestID;
    public static double sum;
    
    public static void createBooking()throws Exception{
        addRoom();
    }
    public static void addRoom()throws Exception{
        Room addRoom1 = new Room();
        
        addRoom1.whatFloor();//method has setters and then goes to another method "numberBeds"
        
        addRoom1.setRoomID(addRoom1.readRoomList(addRoom1.getFloor())); //gets the room ID from a file 
        
        extendBooking(addRoom1.getPricePerNight()); //computes the sum
        
        addRoom1.internetCode(addRoom1.getFloor()); //finds the internet code for the specific floor
        
        //Prints receipt 
        System.out.printf("\nFloor\t:\t%d\nInternet\t:\t%s\nTotal\t:\t%.2f$\nRoom\t:\t%s\n\n",addRoom1.getFloor(), 
                                 addRoom1.internetCode(addRoom1.getFloor()), sum, addRoom1.getRoomID());
    }
       
    public static void extendBooking(double pricePerNight){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days will you be staying in your room?\t :");      
        int days = input.nextInt();
        sum = pricePerNight * days;
        /*
        her skal der måske være en start date og end date hvor den så 
        */
    }
}