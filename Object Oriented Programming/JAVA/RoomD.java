import java.util.Scanner;
public class RoomD extends RoomA{ //Extra Room as requested by the pronunciation,quite similar to the superclass with the addition that it has breakfast and optionally dinner
	private String[] dinner = new String[Creator.monDays];
	private final static double breakfastPerDay = 5;
	private final static double dinnerPerDay = 10;//Object variables,defining the values of all RoomD Rooms breakfastPerDay and dinnerPerDay.And a String table to determine which reservations have dinners or not
	public RoomD(){
	    super(); 
	} //Overwrites the default constructor to avoid double codes
	public RoomD(int maxPeople,double pricePerDay){
	    super(maxPeople,pricePerDay);
	   }//Class Constructor similar to its superclass one
	public boolean addReservation(Reservation reservation){ //Overwrites the Room's method to determine during the Reservation's registeration if the user wants dinner or not                                             
        boolean flag=super.addReservation(reservation);  //It does the pricing as its SuperClasses
	    if( flag == true){                               //if it does it with success
	    System.out.println("Do you want dinner?");
         Scanner scan = new Scanner(System.in);
         String answer = scan.nextLine();              //It asks if the client wants dinner
         for(int i = reservation.getArrival()-1;i<=reservation.getArrival() - 1 + reservation.getDays();i++)
          dinner[i] = answer;                          //And saves the answer  
        }
          return flag;                                //Finally it terminates the programm
       }
       public boolean addReservationGUI(Reservation reservation){ //Overwrites the Room's method to determine during the Reservation's registeration if the user wants dinner or not                                             
       return super.addReservation(reservation);  //It does the pricing as its SuperClasses
	    
                                          //Finally it terminates the programm
       }
	 public double pricing()//Overwrites the default method to calculate the cost of the dinner and the breakfast
     {
        double cost = 0;
        for(int i=0; i<Creator.monDays; i++){
            if(reservTable[i] != null){
            	cost = cost +  pricePerDay + breakfastPerDay*reservTable[i].getPeople() + ((dinner[i].equals("yes"))?dinnerPerDay*reservTable[i].getPeople():0);
            }
        }
        return cost;
     }
     public boolean cancellation(int reservCode){//Overwrites the Room's method to cancel the dinner during the cancellation of the reservation
         for(int k=0; k<Creator.monDays; k++){                            
            if(reservTable[k]!= null){                       //First it scans the Table for entries
            if(this.reservTable[k].getResCode() == reservCode){  //If it finds them it checks if they have the requested code 
            this.reservTable[k] = null;                               //If they fulfil both cases it replaces them with null
            this.dinner[k] = null;
        }
        }
        }
         return true;
        } 
     public boolean setDinner(Reservation res,String s){
          boolean flag = false;
         for(int k=0; k<Creator.monDays; k++)
          if(reservTable[k] != null)
          if(res.getResCode() == reservTable[k].getResCode()){
              dinner[k] = s;flag =true;
            }
          return flag;
        }
}
