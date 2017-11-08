import java.io.*;
import java.util.*;

public class Room {
    private int roomID;
    private int numberOfBeds; 
    private boolean internetAccess;
    private double pricePerNight;
    private int floor;
    private double sum;
    String bed;

    public Room(){} //null constructor
    
    //constructor with parameters
    public Room(int roomID, int numberOfBeds, boolean internetAccess, double pricePerNight, int floor){
      this.roomID = roomID;
      this.numberOfBeds = numberOfBeds;
      this.internetAccess = internetAccess; 
      this.pricePerNight = pricePerNight;
      this.floor = floor;
    }
      
    public String toString(){
        return String.format("Room ID: %d\tNumber of beds: %d\tInternet access: %b\tPrice per night: %.2f\tFloor: %d",roomID, numberOfBeds, internetAccess, pricePerNight, floor);
    }
    
    public void saveToFile(String fileName)throws FileNotFoundException{
        PrintStream outputToFile = new PrintStream(new FileOutputStream(fileName, true)); 
        outputToFile.printf("%d %d %b %.2f %d\n",roomID, numberOfBeds, internetAccess, pricePerNight, floor);
    }
    
    /*public int readRoomList(int floor)throws Exception{
        Scanner roomList = new Scanner(new File("roomList.txt"));
        int[] roomIDEntry = new int[6];
        
        //save line in array
        for(int i = 0; i < 6; i++){ 
            if(roomList.hasNextLine()){ //every time it has a line it saves that line in the array
                roomIDEntry[i] = roomList.nextInt();
            }
        }
        //sets roomID 
        if(floor == 1){
            if (numberOfBeds > 4){
               setRoomID(roomIDEntry[0]);
               return roomIDEntry[0];
            }
            if (numberOfBeds < 5){
               setRoomID(roomIDEntry[1]);
               return roomIDEntry[1];
            }
        }
        else if (floor == 2){
            if (numberOfBeds > 4){
               setRoomID(roomIDEntry[2]);
               return roomIDEntry[2];
            }
            else if (numberOfBeds < 5){
               setRoomID(roomIDEntry[3]);
               return roomIDEntry[3];
               
            }   
        }
        else if (floor == 3){
            if (numberOfBeds > 4){
               setRoomID(roomIDEntry[4]);
               return roomIDEntry[4];
            }
            else if (numberOfBeds < 5){
               setRoomID(roomIDEntry[5]);
               return roomIDEntry[5];
            }
        }
        return -1; //if it didn't find anything in list
    }*/
    
    public String internetCode(int floor) throws Exception {
        Scanner read = new Scanner(new File("internet.dat"));
        
        //makes an array
        String[] entry = new String[3];
        
        //save line in array
        for(int i = 0; i < 3; i++){ 
            if(read.hasNextLine()){ //every time it has a line it saves that line in the array
                entry[i] = read.nextLine();
            }
        }
        //see what floor and then print the line from then file.
        if (floor == 1){
           // read from second line of file
           return "Password for the first floor: " + entry[0];
        }
        else if (floor == 2){
           // read from second line of file
           return "Password for the second floor: " + entry[1];
        }
        else if (floor == 3){
           //read from third line of file
           return "Password for the second floor: " + entry[2];
        }
        else return "Unavailable to reach that floor.";
                    
    }
    /*public int numberBeds(){
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like 1 or 2 beds in your room?\t:\t");
        int entry = input.nextInt();
        this.numberOfBeds = numberOfBeds - entry;
        if (numberOfBeds >= 0 && numberOfBeds <= 6 && entry > 0 && entry < 3){
            System.out.println("There are "+ numberOfBeds +" beds left.");
            
        }else {
            System.out.println("Please enter 1 or 2.");
            numberOfBeds = 6;
            numberBeds();
        }
        return numberOfBeds;
    }*/
    public int wholeSum(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days will you be staying in your room?\t :");
        /*
        her skal der måske være en start date og end date hvor den så 
        */
        int days = input.nextInt();
        sum = pricePerNight * days;
    
      return days;
    }
    
    public String internet(){
        if (internetAccess){ //the condition is true
            if (floor == 1) {
                return "You now have internet access for first floor.";
            }
            else if (floor == 2){
                return "You now have internet access for second floor.";
            }
            else if (floor == 3){
                return "You now have internet access for third floor.";
            }
        }else
            return "You don't have internet access.";
        return "";
    }
    public void whatFloor(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nWhat what sort of room would you like?\nThe prices are 200$ (one bed), 250$(double bed) and 300$(suit).\nType \"1\" for a one bed room.\n" +
                     "Type \"2\" for a double bed room.\nType \"3\" for a suit.\nEnter\t:\t");
        String answer = input.next();
        
        //a switch that set the fields to values and then goes to a method that lets you decide 
        switch (answer) {
            case "1":
                setPricePerNight(200.0);
                setFloor(1);
                setInternetAccess(true); //a boolean is default on false
                //numberBeds();
                break;
            case "2":
                setPricePerNight(250.0);
                setFloor(2);
                setInternetAccess(true); //a boolean is default on false
                //numberBeds(); 
                break;
            case "3":
                setPricePerNight(300.0);
                setFloor(3);
                setInternetAccess(true); //a boolean is default on false
                //numberBeds();
                break;
            default:
                //This will run the method again.
                System.out.print("\nNot a valid floor. Please enter again.\n");
                whatFloor();
        }

    }
    //change price per night for each room
    public void changePriceForRoom(){
       Scanner console = new Scanner(System.in);
       System.out.println("Enter new price for the room.");
       setPricePerNight(console.nextDouble());
       System.out.println("The price is now: " + getPricePerNight()+"$");
    }
    
    //getters
    public int getRoomID(){ return roomID; }

    public int getNumberOfBeds(){ return numberOfBeds; }

    public boolean getInternetAccess(){ return internetAccess; }

    public double getPricePerNight(){ return pricePerNight; }

    public int getFloor(){ return floor; }

    public double getSum(){ return sum; }


    //setters
    public void setRoomID(int roomID){ this.roomID = roomID; }

    public void setNumberOfBeds(int numberOfBeds){ this.numberOfBeds = 6 - numberOfBeds; } 

    public void setInternetAccess(boolean internetAccess){ this.internetAccess = internetAccess; }

    public void setPricePerNight(double pricePerNight){ this.pricePerNight = pricePerNight; }

    public void setFloor(int floor){ this.floor = floor; }


}
