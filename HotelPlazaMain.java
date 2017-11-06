import java.awt.*;
import java.io.*;
import java.util.*;

public class HotelPlazaMain {
   public static void main(String[] args)throws Exception{ 
      Guest[] guest = new Guest[8];
      Room[] room = new Room[6];
      loadFile("roomList.txt", room);
      
      showMenu(room);
            
      
   }
   public static void addRoom(Room[] room)throws Exception{
      Scanner console = new Scanner(System.in);
      
      System.out.print("Enter the number of beds in the room.\t");
      int numberOfBeds = console.nextInt();
      System.out.print("\nInternet access enter: \"true\" or \"false\"\t");
      boolean internetAccess = console.nextBoolean();
      System.out.print("\nEnter price per night: \t");
      double pricePerNight = console.nextDouble();
      System.out.print("\nEnter the floor number: \t");
      int floor = console.nextInt();
      
      //adds a new object to existing array with parameters       
      room[roomIndex(room)] = new Room(roomIDUpdate(room), numberOfBeds, internetAccess, pricePerNight, floor); 
      saveRoom(room);
       
   }
   public static void loadFile(String fileName,Room[] room)throws Exception{
      Scanner read = new Scanner(new File(fileName));
      int count = 0;
      while(read.hasNextLine()){
         Scanner readLine = new Scanner(read.nextLine());
         room[count] = new Room(readLine.nextInt(),readLine.nextInt(),readLine.nextBoolean(),readLine.nextDouble(),readLine.nextInt());                  
      System.out.println(count);
      count++;
      }
   }
   public static int roomIndex(Room[] room){
      for(int i = 0; i < room.length; i++){
         if(room[i] == null){
            return i;
         }
      }
      return -1; //if not found
   }
   public static int roomIDUpdate(Room[] room){
      int count = 0; //starting room ID
      
         if(roomIndex(room)>1){ 
            count = room[roomIndex(room)-1].getRoomID(); //gets last place to count  
         }
         
      count++; //increment room ID  
      return count;
   }
   public static void saveRoom(Room[]room)throws FileNotFoundException{
      for(int i = 0; i < roomIndex(room); i++){ 
         room[i].saveToFile("roomList.txt");
      }
   }
   public static void printRoomList(Room[]room)throws Exception{
      for(int i = 0; i < roomIndex(room); i++){
         System.out.println(room[i].toString());
      }
   }
   
   public static int showMenu(Room[]room)throws Exception{
      //int menuItem;
      Scanner console = new Scanner(System.in);
      Staff staff = new Staff();
      Guest guest = new Guest();
      Booking booking = new Booking();
    //  Room room = new Room();
      //Scanner staffList = new Scanner (new File("StaffList.txt")).useDelimiter(",");
      int menuItem = -1;
      while (menuItem != 0){
         menu();//this is a print method
         menuItem = console.nextInt();
         
         switch (menuItem){
            case 1: addRoom(room); break; //same as case 6
            case 2: guest.createNewGuest(console); break;
            case 3: guest.readGuestList(); break;
            case 4: staff.createNewStaff(console); break;
            case 5: staff.printStaffList(); break;
            case 6: booking.createBooking(); break;
            //case 7: room.changePriceForRoom(); break; //set price per night for each room
            //case 8: changeGuest(); break;
            //case 9: changeStaff(); break;
            //case 10: extendBooking(); break;
            //case 11: printBill(); break; //booking "addRoom" has receipt
            case 12: printRoomList(room);
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
        System.out.println("11. See beds avaliable");
        System.out.println("12. Print Receipt");
        System.out.println("0. Exit");
    }

   
}