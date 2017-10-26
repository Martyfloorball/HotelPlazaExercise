public class Room {
    private int roomID;
    private int numberOfBeds;
    private Boolean internetAccess;
    private double pricePerNight;
    private int floor;


    //getters
    public int getRoomID() {
        return roomID;
    }

    public int getNumberOfBeds(){ return numberOfBeds; }

    public Boolean getInternetAccess(){ return internetAccess; }

    //setters
    public void setRoomID(){ this.roomID = roomID; }

    public void setNumberOfBeds(){ this.numberOfBeds = numberOfBeds; }

    public void setInternetAccess(){ this.internetAccess = internetAccess; }


}