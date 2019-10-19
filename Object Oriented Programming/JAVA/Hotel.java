import java.util.ArrayList;
public class Hotel{
     private String hotelName;
     private ArrayList<Room> roomArray = new ArrayList<Room>();
     private ArrayList<Reservation> reservationArray = new ArrayList<Reservation>(); //Object variables as requested by the pronunciation
     public Hotel(String hotelName){
      this.hotelName=hotelName;
     }   //Class constructor,defining hotelName
     public boolean addRoom(Room room){  //Method to add a Room to the running's hotel Room Array
         return this.roomArray.add(room);
     }
     public Room codeRoomRetrieval(int code){     //Method to retrieve a Room based on room's code from the running's hotel Room Array
         for(int i = 0;i <= this.roomArray.size() - 1;i++)
         if(this.roomArray.get(i).getCode() == code){
             return this.roomArray.get(i);
         }
         return null;
     }
     public Reservation codeReservationRetrieval(int code){ //Method to retrieve a Reservation based on room's code from the running's hotel Reservation Array
         for(int i = 0;i <= this.reservationArray.size() - 1;i++)
         if(this.reservationArray.get(i).getResCode() == code){
             return this.reservationArray.get(i);
            }
         return null;
     }
     public boolean roomAddReservation(Reservation res,int code){ //Method to add a reservation to the ruuning hotel's Reservation Array given the Reservation and the Room's code
         Room room = this.codeRoomRetrieval(code); //It retrieves the Room and it registers it to a method variable(Room)
         boolean flag = false;//Method variable to determine if the reservation was a success
         if(room != null) //it first checks if the Room was retrieved succesfully
           flag = room.addReservation(res);  //And trys to add the reservation,setting to the flag the result
         if(flag == true){
             System.out.println("Reservation " + res.getResCode() + " was made with success in Room " + code);
             this.reservationArray.add(res);
            }
         else{
             System.out.println("Reservation "+ res.getResCode() + " was failed to register in the Room " + code);
            }//Based on the result it shows the suitable messages and termiinates the programm by returning the flag
         return flag;
        }
     public int addReservation(Reservation res){   //Method to add a Reservation to the running's hotel Reservation Array given only the Reseervation and registering it to the first available Room
           for(int i = 0;i <= this.roomArray.size() - 1;i++){ //It scans the running's hotel Room Array and checks if the reservation can be made
           if(this.roomAddReservation(res,this.roomArray.get(i).getCode()) == true){
               return this.roomArray.get(i).getCode();
            } //If yes it adds to the success message the room code and terminates the programm by returning it
           else{
               continue;
            }
         }
           return 0;//if not it terminates the programm returing 0 as requested by the pronunciation
     }
     public boolean resCancellation(int code){  //Method to cancel a resrvation base on reservation's code
            Reservation res = this.codeReservationRetrieval(code);//It retrieves the Reservation and it registers it to a method variable(Reservation)
            if(res != null){ //it first checks if the Reservation was retrieved succesfully
              if(res.getRoom().cancellation(code)== true){ //If yes it checks if the cancellation can be done
              for(int i = 0;i <= this.reservationArray.size() - 1;i++)
              if(this.reservationArray.get(i).getResCode() == code){
                  System.out.println("Reservation " +code+" in Room "+res.getRoom().getCode() +" cancelled");
                  this.reservationArray.remove(i);
                  return true;
                }//If yes it removes the Reservation from the ruuning hotel's Reservation Array printing the suitable message and terminating the method 
            }
           }
            System.out.println("Reservation " + code + " cancellation was unsuccessfull"); //If either of the two cases was false it prints the suitable unsuccesful message and terminates the method
            return false;
     }
     public double incomeCalc(){ //Method to calculate the whole income from all the Rooms combined 
           double cost = 0; //Method Variable to keep track of the ammount
           for(int i = 0;i <= this.roomArray.size() - 1;i++){
                cost += this.roomArray.get(i).pricing(); //It scans the running's hotel Reservation Array and it adds the amount to the method variable using the Room's pricing() methods
           }
           return cost; //And when it is done it terminates the method by returning the whole amount
     }
     public String reservPlan() //Method to graphically represent the Reservations for all the running's hotel Rooms 
        {
            String S;
            S = "Δωματιο";
            for(int i = 0;i<Creator.monDays-1;i++){
            S+=((i+1<10)?("\t0"+(i+1)):("\t"+(i+1)));
        }                               
        S+=("\t"+Creator.monDays);
         for(int i = 0;i <= this.roomArray.size() - 1;i++){
        S+=("\n");
        S+=(this.roomArray.get(i).getCode());
        for(int j = 0;j<Creator.monDays;j++)
        S+=("\t"+((this.roomArray.get(i).checkDay(j) == true)?"*":"_"));
        }
        System.out.println(S);
        return S;
     }
        public double incomeCalc(int rCode){//Method to return the running's hotel room's income based in its code
    	 Room room1 = this.codeRoomRetrieval(rCode);//It first creates a temporary room that stores the room that retrieved 
    	if(room1!=null){
    		return room1.pricing();
    	 } //if it exists it returns its pricing
    	else{
    		return 0;
    	}//If not,0
     }
     public ArrayList<Room> getRoomArray(){
         return roomArray;
     }
     public ArrayList<Reservation> getReservationArray(){
         return reservationArray;
     }//Methods to return the running's hotel Arrays
}