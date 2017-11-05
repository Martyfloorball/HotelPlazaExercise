import java.io.*;
import java.util.*;

public class Menu{
    int menuItem;
    //menuItem = showMenu();
    
    public static int showMenu()throws Exception{
      Scanner console = new Scanner(System.in);
      Staff staff = new Staff();
      Guest guest = new Guest();
      Booking booking = new Booking();
      Room room = new Room();
      //Scanner staffList = new Scanner (new File("StaffList.txt")).useDelimiter(",");
      int menuItem = -1;
      while (menuItem != 0){
         menu();
         menuItem = console.nextInt();
         
         switch (menuItem){
            case 1: Booking.addRoom(); break;
            case 2: guest.createNewGuest(console); break;
            case 3: guest.readGuestList(); break;
            case 4: staff.createNewStaff(console); break;
            case 5: staff.printStaffList(); break;
            case 6: booking.createBooking(); break;
            case 7: room.changePriceForRoom(); break;
            //case 8: changeGuest(); break;
            //case 9: changeStaff(); break;
            //case 10: extendBooking(); break;
            //case 11: printBill(); break;
            case 0: System.out.println("Goodbye"); break;
            default : System.out.println("Invalid, please type the number of the menu you wish to access");
         }
      }   
      return 0; //this is important because it makes the menu keep running until you
                //enter the number that lets it break out of the loop
    }

    public static void menu(){
        System.out.println("1. Create Room");
        System.out.println("2. Create Guest");
        System.out.println("3. Print Guest Info");
        System.out.println("4. Create Staff Member");
        System.out.println("5. Print Stafflist");
        System.out.println("6. Create Booking");
        System.out.println("7. Change Price For Room");
        System.out.println("8. Change Guest");
        System.out.println("9. Change Staff");
        System.out.println("10. Extend Booking");
        System.out.println("11. Print Receipt");
        System.out.println("0. Exit");
    }
    /*public static void receipt() throws Exception{
        //some text printf
        //name of guest, floor, total and internet code, roomID
        System.out.print("Printing receipt");
        for (int l = 0; l < 3; l++){//loop 3 times
            Thread.sleep(500);//half second
            System.out.print(".");
        }
        System.out.println();
    }*/
}