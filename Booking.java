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
        addRoom1.setRoomID("1a");
        System.out.println(addRoom1.getRoomID());
        addRoom1.whatFloor();//this 
        
        extendBooking(addRoom1.getPricePerNight());
        
        addRoom1.readRoomList(addRoom1.getFloor());

        //addRoom1.numberBeds();
        //addRoom1.setFloor(2);
        addRoom1.internetCode(addRoom1.getFloor());
        //addRoom1.readRoomList(addRoom1.getFloor());
        System.out.println(addRoom1.getRoomID());

        System.out.printf("Floor\t:\t%d\nInternet\t:\t%s\nTotal\t:\t%.2f$\nRoom\t:\t%s\n",addRoom1.getFloor(), 
                                 addRoom1.internetCode(addRoom1.getFloor()), sum, addRoom1.getRoomID());
    }
       
    public static void extendBooking(double pricePerNight){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days will you be staying in your room?\t :");
        /*
        her skal der måske være en start date og end date hvor den så 
        */
        int days = input.nextInt();
        sum = pricePerNight * days;
    }
}