public class RoomE extends RoomB{     //Extra Room as requested by the pronunciation,quite similar to its superclass with the difference that a cancellation can be made but with extra cost(50% of the price)  that it is co-ordinated to the pricing method
    private static double extraCharges = 0; //Class variable to keep track of the cancellation()'s incomes
    public RoomE(){
        super();
    } //Overwrites the default constructor to avoid double codes
    public RoomE(int maxPeople,double pricePerDay,double discountPerDay){
     super(maxPeople,pricePerDay,discountPerDay);
    }   //Class constructor,defining maxpeople,pricePerDay and discountPerDay
    public boolean cancellation(int reservationCode)//Method to overwrite the cancellation() method from the class RoomB
    {
        RoomE room1 = new RoomE();
        room1.reservTable = this.reservTable;
        room1.pricePerDay = this.pricePerDay;
        room1.discountPerDay = this.discountPerDay; //Method variable to copy the running room so it will be uneffected by the cancellation() changes
        boolean cancel = ((RoomA)this).cancellation(reservationCode); //Method variable to check if the cancellation can be made,and if yes it mades it
        if(cancel == true){
          for(int i = 0;i<Creator.monDays;i++)
          {
            if(room1.reservTable[i].getResCode() != reservationCode)
            room1.reservTable[i] = null;                                //It empties in the running RoomE's copy all the reservation that is not of the requested code
        }
         extraCharges = ((RoomB)this).pricing() /2;                     //And then calculates the extra Pricing by calling the pricing() of the copy(as RoomB),as it has no other reservations
    }
    return cancel;
 }
 public double pricing()  //Method to overwrite the pricing method of the class RoomB that calculates and the extraCharges from previus cancellations
    {
        return(super.pricing() + extraCharges);      
    }
}