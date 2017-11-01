import java.awt.*;
import java.io.*;
import java.util.*;

public class HotelPlazaMain {
   public static void main(String[] args)throws Exception{ 
      int menuItem;
      //menuItem = showMenu();
      addRoom();
      //numberOfBeds();
      
   }
   
   static int showMenu()throws Exception{
      Scanner console = new Scanner(System.in);
      Staff staff = new Staff();
      Guest guest = new Guest();
      //Scanner staffList = new Scanner (new File("StaffList.txt")).useDelimiter(",");
      int menuItem = -1;
      while (menuItem != 0){
         System.out.println("1. Create Room");
         System.out.println("2. Create Guest");
         System.out.println("3. Print Guestlist");
         System.out.println("4. Create Staff Member");
         System.out.println("5. Print Stafflist");
         System.out.println("6. Create Booking");
         System.out.println("7. Change Price For Room");
         System.out.println("8. Change Guest");
         System.out.println("9. Change Staff");
         System.out.println("10. Extend Booking");
         System.out.println("11. Print Receipt");
         System.out.println("0. Exit");
         menuItem = console.nextInt();
         switch (menuItem){
         //case 1: createRoom();
            //break;
         case 2: guest.createNewGuest(console);
            break;
         case 3: guest.readGuestList();
            break;
         case 4: staff.createNewStaff(console);
            break;
         //case 5: staff.printStaffList();
            //break;
         //case 6: createBooking();
            //break;
         //case 7: changePriceForRoom();
            //break;
         //case 8: changeGuest();
            //break;
         //case 9: changeStaff();
           // break;
         //case 10: extendBooking();
            //break;
         //case 11: printBill();
            //break;
         case 0: System.out.println("Goodbye");
            break;
         default : System.out.println("Invalid, please type the number of the menu you wish to access");
         
         }
         }   
      return 0;
      }

    public static void intro(){
        //Scanner answer = new Scanner(System.in);
        System.out.println("Welcome to Hotel Plaza\n");


    }
    public static void guest(){
        Guest addGuest1 = new Guest();
    }
    public static void addRoom()throws Exception{
        //Scanner input = new Scanner(System.in);
        Room addRoom1 = new Room();
        addRoom1.whatFloor();
        addRoom1.readRoomList(addRoom1.getFloor());

        //addRoom1.numberBeds();
        //addRoom1.setFloor(2);
        addRoom1.internetCode(addRoom1.getFloor());
        addRoom1.wholeSum();
        


        
        
        System.out.printf("Floor\t:\t%d\nInternet\t:\t%s\nTotal\t:\t%.2f$\nRoom\t:\t%s\n",addRoom1.getFloor(), 
                                 addRoom1.internetCode(addRoom1.getFloor()), addRoom1.getSum(),addRoom1.getRoomID());

        System.out.print("Room : " + addRoom1.getRoomID());
    }
    public static void receipt() throws Exception{
        //some text printf
        //name of guest, floor, total and internet code
        System.out.print("Printing receipt");
        for (int l = 0; l < 3; l++){//loop 3 times
            Thread.sleep(500);//half second
            System.out.print(".");
        }
        System.out.println();


    }
}
