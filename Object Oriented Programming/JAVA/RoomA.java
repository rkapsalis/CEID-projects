public class RoomA extends Room{
    protected double pricePerDay;                    //Object variables as requested by the pronunciation
    public RoomA(){
        super();
    } //Overwrites the default constractor to avoid double codes
    public RoomA(int maxPeople,double pricePerDay){
     super(maxPeople,0);
     this.pricePerDay = pricePerDay;
    }   //Class constructor,defining maxpeople and pricePerDay
     public double pricing()                         //Method to find the sum of the price of the combined registered RoomA's Reservations.
     {
        double cost = 0;    //Method Variable to keep track of the ammount
        for(int i=0; i<Creator.monDays; i++)         //The loop scans for not empty entries 
        {
            if(reservTable[i] != null){
                 cost += pricePerDay;                //When it finds them it adds the pricePerDay
            }
        }
        return cost;                                 //And terminates the method by returning the cost after scanning the whole table
     }
}
