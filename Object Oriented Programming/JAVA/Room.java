public class Room
{
    private int code;
    protected int maxPeople;
    private double price;
    protected Reservation[] reservTable = new Reservation[Creator.monDays];//Object variables as requested by the pronunciation
    private static int runningCode = 1;//Class variable,runningCode to keep code positive and unique for each Room as requested by the pronunciation
    public Room(){
        this.code= runningCode++;
    } //Overwrites the default constructor to avoid double codes
    public Room(int maxPeople,double price)
    {
     this.code= runningCode++;
     this.maxPeople = maxPeople;
     this.price = price;
    }          //Class constructor,defining running Room's code,maxPeople and price
    public boolean addReservation(Reservation reservation){                                              //Method to add Reservation to the running Room
        if(this.maxPeople < reservation.getPeople()){
            return false;}                                      //It first checks if requested reservation's people exceeds running Room's maxPeople,
        try{
         for(int j = reservation.getArrival()-1;j <=(reservation.getArrival() + reservation.getDays()-2);j++) //then the Room's reservationTable for possible entrys
         if(this.reservTable[j] != null){
             return false;}                                                   //and in either case terminates the method by returning false
         for(int j = reservation.getArrival()-1;j <=(reservation.getArrival() + reservation.getDays()-2);j++) //If not it registers the reservation in each of the requested days
          this.reservTable[j] = reservation;                                                               // registers the Room in the reservation and terminates the method by returning true 
          reservation.setRoom(this);
          return true;  
             }
        catch(java.lang.ArrayIndexOutOfBoundsException e){
            return false;
        }
       
    }
    public double pricing()
    {    
        double cost = 0; //Method Variable to keep track of the ammount
        for(int i=0; i<Creator.monDays; i++){                            //Method to find the sum of the price of the combined registred Room's Reservations
            if(reservTable[i]!= null){                       //The loop scans for not empty entries 
                cost += price*reservTable[i].getPeople();    //When it finds them it adds the product of the Room's price per person and the number of the Reservation's persons 
            }
        }
        return cost;                                         //And terminates the method by returnig the cost after scanning the whole table
    }
    public boolean cancellation(int reservationCode){        //Method to cancel a reservation,based on it's code in the running Room's
        for(int k=0; k<Creator.monDays; k++){                            
            if(reservTable[k]!= null){                       //First it scans the Table for entries
            if(this.reservTable[k].getResCode() == reservationCode){  //If it finds them it checks if they have the requested code 
            this.reservTable[k] = null;                               //If they fulfil both cases it replaces them with null
        }
        }
        }
         return true;                                           //Having or not cancelled any reservations it terminates the programm by returning true
    }                                                   
    public double completeness()
    {
        double notEmpty = 0;  //Method variable to keep track of the not empty rooms
        double percent;       //Method variable to calculate the percent of compiteness
         for(int i=0; i<Creator.monDays; i++){                           //Method to find the complitness percentage of the combined registred Reservations.
            if(reservTable[i]!= null){                       //The loop scans for not empty entries 
                notEmpty++;                                  //When it finds them it increases the local variable notEmpty by one,keeping truck of the taken rooms
            }
        }
        percent = (notEmpty/(double)Creator.monDays)*(double)100;         //Then it calculates the percentage 
        return percent;                                      //and terminates the method by returning it
    }
    public int getCode(){
        return this.code;
    }                  //Method to return the value of the code of the running Room
    public boolean checkDay(int i){
        return ((this.reservTable[i] == null)?false:true);
    } //Method to check if the requested day is occupied in the ruuning Room's Table
    public int getMaxPeople(){
        return this.maxPeople;
    }//Method to return the value of the people of the running Room
    }