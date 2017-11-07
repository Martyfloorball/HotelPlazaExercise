import java.io.*;
import java.util.*;

public class HotelPlazaMain {
   public static void main(String[] args)throws Exception{ 
      Room[] room = new Room[6]; 
      loadFile("roomList.txt", room); //load file 
      
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
      Scanner read = new Scanner(new File(fileName)); //scans the file 
      int count = 0; //initialze variable
      while(read.hasNextLine()){ //while it has a line
         Scanner readLine = new Scanner(read.nextLine()); //new scanner that scans the current line
         //scans for different tokens
         room[count] = new Room(readLine.nextInt(),readLine.nextInt(),readLine.nextBoolean(),
                              readLine.nextDouble(),readLine.nextInt());                  
      count++; //increment
      }
   }
   public static int roomIndex(Room[] room){
      for(int i = 0; i < room.length; i++){
         if(room[i] == null){ // if the array space don't have anyt info, then it returns current i
            return i;
         }
      }
      return -1; //if not found
   }
   //update roomID
   public static int roomIDUpdate(Room[] room){
      int count = 0; // initialize variable
      for(int i = 0; i < room.length; i++){ //for loop on the arrays length (6)
      count++; //increment room ID  
         if(room[i] == null){ //when the space is null it will return the current count it has 
            return count;   
         }
      }
      return count;
   }
   public static void saveRoom(Room[]room)throws FileNotFoundException{
      PrintStream override = new PrintStream(new File("roomList.txt")); //override file
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
      Scanner console = new Scanner(System.in);
      //initilize objects
      Staff staff = new Staff();
      Guest guest = new Guest();
      Booking booking = new Booking();
      Room room1 = new Room();
      int menuItem = -1; //dummy to keep looping until sentinel is entered
      while (menuItem != 0){
         menu();//this is a print method
         menuItem = console.nextInt();
         
         switch (menuItem){
            case 1: addRoom(room); break;
            case 2: guest.createNewGuest(console); break;
            case 3: guest.readGuestList(); break;
            case 4: staff.createNewStaff(console); break;
            case 5: staff.printStaffList(); break;
            case 6: booking.createBooking(); break;
            case 7: room1.changePriceForRoom(); break; //set price per night
            //case 8: changeGuest(); break;
            case 9: staff.showStaffMenu(); break;
            //case 10: extendBooking(); break;
            //case 11: printBill(); break; //create room ha bill?
            case 12: printRoomList(room); break;
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
        System.out.println("12. Print Rooms");
        System.out.println("0. Exit");
    }
}