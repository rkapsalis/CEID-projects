public class RoomC extends Room{
    private int minPeople;
    private int minDays;   //Object variables as requested by the pronunciation
    public RoomC(){
        super(); 
    } //Overwrites the default constructor to avoid double codes
    public RoomC(int maxPeople,double price,int minPeople,int minDays)
    {
     super(maxPeople,price);
     this.minDays= minDays;
     this.minPeople = minPeople;
    }          //Class constructor,defining running Room's code,maxPeople,price,minPeople and minDays
    public boolean addReservation(Reservation reservation){                                              //Method to add Reservation to the running RoomC
        if(this.maxPeople < reservation.getPeople() || this.minPeople > reservation.getPeople() || this.minDays > reservation.getDays())
        {
            return false;
        }                                      //It first checks if requested reservation's people exceeds running RoomC's maxPeople or eluds minPeople or minDays,
        try{
        for(int j = reservation.getArrival() - 1;j <=(reservation.getArrival() + reservation.getDays());j++) //then the RoomC's reservationTable for possible entrys
        if(this.reservTable[j] != null){
            return false;
        }                                                   //and in case of occupied days terminates the method by returning false
        for(int j = reservation.getArrival() - 1;j <=(reservation.getArrival() + reservation.getDays());j++)  //If not it registers the reservation in each of the requested days
        this.reservTable[j] = reservation;                                                              
        reservation.setRoom(this);
        return true;                                                                                          // and terminates the method by returning true 
        
     
    }catch(java.lang.ArrayIndexOutOfBoundsException e){
        return false;
    }
     
    }
}
    

