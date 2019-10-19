public class RoomB extends RoomA{
    protected double discountPerDay;                 //Object variables as requested by the pronunciation
    public RoomB(){
        super();
    } //Overwrites the default constructor to avoid double codes
    public RoomB(int maxPeople,double pricePerDay,double discountPerDay){
     super(maxPeople,pricePerDay);
     this.discountPerDay = discountPerDay;
    }   //Class constructor,defining maxpeople,pricePerDay and discountPerDay
    public double pricing()                       //Method to find the sum of the price of the combined registred Room's Reservations taking into account the discount 
     {
        double cost = 0; //Method variable to keep track of the ammoun
        boolean exceed = false;  //Method variable to check if it is the first time that it exceeds the disqount limit requested by the pronunciation
        double finPrice = 0;
        for(int i=0; i<Creator.monDays; i++){                 //The loop scans for not empty entries 
            if(this.reservTable[i] != null){
          for(int j = 0;j <= this.reservTable[i].getDays()-1;j++){       //When it finds them,it calculates the whole amount of the reservation day by day
                     if((pricePerDay - (discountPerDay*j) )>= (pricePerDay/2)){   //It checks if the final price of the day is below the 50% of the starting price 
                     cost += (pricePerDay - (discountPerDay*j));                  //if not it adds the price substracted by the discount 
                   }
                   else{                    //If yes
                        if(exceed ==false)  //it checks if it is he first time that it exceeds the 50%
                        {                   //if yes it saves the price that will be charging from now on
                            finPrice =((j==0)?(pricePerDay):(pricePerDay - discountPerDay*(j-1)));
                            exceed =true;
                        }                 //And then it adds that price until the current reservation is over
                        cost += finPrice; 
                       }
                    }
        i += this.reservTable[i].getDays();  //At the end it jumps the reservations days in the table
     }
     }
    return cost;                            //And terminates the method by returning the cost
}
public boolean cancellation(int reservationCode){
    return false;
}  //Method to overwrite the cancellation method of the class Room,as requested by the pronunciation
}
