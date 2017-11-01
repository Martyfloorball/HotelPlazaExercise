import java.io.*;
import java.util.*;

public class Room {
    private String roomID;
    private int numberOfBeds = 6; //ændre?
    private boolean internetAccess;
    private double pricePerNight;
    private int floor;
    private double sum;
    String bed;


    public String toString(){
        return roomID + " " + numberOfBeds + " " + internetAccess + " " + pricePerNight + " " + floor + " " + sum + " " + bed;
    }
    
    public void readRoomList(int floor)throws Exception{
        Scanner roomList = new Scanner(new File("roomList.txt"));
        String[] roomIDEntry = new String[6];
        
        //save line in array
        for(int i = 0; i < 6; i++){ 
            if(roomList.hasNextLine()){ //every time it has a line it saves that line in the array
                roomIDEntry[i] = roomList.nextLine();
            }
        }
        //sets roomID 
        if(floor == 1){
            if (numberOfBeds == 6){
               setRoomID(roomIDEntry[0]);
            }
            if (numberOfBeds < 5){
               setRoomID(roomIDEntry[1]);
            }
        }
        else if (floor == 2){
            if (numberOfBeds == 6){
               setRoomID(roomIDEntry[2]);
            }
            if (numberOfBeds < 5){
               setRoomID(roomIDEntry[3]);
            }   
        }
        else if (floor == 3){
            if (numberOfBeds == 6){
               setRoomID(roomIDEntry[4]);
            }
            if (numberOfBeds < 5){
               setRoomID(roomIDEntry[5]);
            }
        }
    }
    /*public void saveToArray(Scanner){
        
    }
    */
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
    public void numberBeds(){
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like 1 or 2 beds in your room?\t:\t");
        int entry = input.nextInt();
        this.numberOfBeds = numberOfBeds - entry;
        if (numberOfBeds >= 0 && numberOfBeds <= 6 && entry > 0 && entry < 3){
            System.out.println("There are "+ numberOfBeds +" left.");
            
        }else {
            System.out.println("Please enter 1 or 2.");
            numberOfBeds = 6;
            numberBeds();
        }
    }
    public void wholeSum(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days will you be staying in your room?\t :");
        /*
        her skal der måske være en start date og end date hvor den så 
        */
        int days = input.nextInt();
        sum = pricePerNight * days;
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
                "Type \"2\" for a double bed room.\nType \"3\" for a suit.\t: ");
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
                numberBeds();
                break;
            default:
                //This will run the method again.
                System.out.print("\nNot a valid floor. Please enter again.\n");
                whatFloor();
        }

    }

    //getters
    public String getRoomID(){ return roomID; }

    public int getNumberOfBeds(){ return numberOfBeds; }

    public boolean getInternetAccess(){ return internetAccess; }

    public double getPricePerNight(){ return pricePerNight; }

    public int getFloor(){ return floor; }

    public double getSum(){ return sum; }


    //setters
    public void setRoomID(String roomID){ this.roomID = roomID; }

    public void setNumberOfBeds(int numberOfBeds){ this.numberOfBeds = 6 - numberOfBeds; } 

    public void setInternetAccess(boolean internetAccess){ this.internetAccess = internetAccess; }

    public void setPricePerNight(double pricePerNight){ this.pricePerNight = pricePerNight; }

    public void setFloor(int floor){ this.floor = floor; }


}
