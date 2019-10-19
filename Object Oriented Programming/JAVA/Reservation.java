public class Reservation{
    private String clientName;
    private int resCode;
    private int arrival;
    private int days;
    private int people;
    private Room room = null; //Object variables as requested by the pronunciation
    private static int runningCode = 1; //Class variable,runningCode to keep code positive and unique for each Room as requested by the pronunciation
    public Reservation(){
        this.resCode = runningCode++;
    }//Overwrites the default constructor to avoid double resCodes
    public Reservation(String clientName,int arrival,int days,int people){
        this.resCode = runningCode++;
        this.clientName = clientName;
        this.arrival = arrival;
        this.days = days;
        this.people = people;
    }          //Class constructor,defining running Reservation's resCode by ascending order and clientName,arrival,days and people by programmer's definition
    public void setRoom(Room room){
        this.room = room;
    }          //Method to set room for the running Reservation(room is private,and direct access is prohibited from other classes)                            
    public String getClientName(){
        return clientName;
    }
    public int getResCode(){
        return resCode;
    }
    public int getArrival(){
        return arrival;
    }
    public int getDays(){
        return days;
    }
    public Room getRoom(){
        return this.room;
    }
    public int getPeople(){
        return people;
    }          //Methods to return resCode,clientName,arrival,days,room and people values from the running Reservation(they are all private and direct access is prohibited from other classes)
}