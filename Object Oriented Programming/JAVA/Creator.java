import java.util.Random;
import java.text.DecimalFormat;
public abstract class Creator{//Abstract class that manages several creating to loose up some weight from the Run class and help implement it's key elements to the GUI.Is declared as abstract cause there is no use of it's objects.
   private static Random rand = new Random();
   public static final int monDays = 30;//Static variable that determines the month days for the whole program
    public static Hotel createHotel(String s){//Method that creates a hotel,a bunch of rooms and it adds them to the hotel previously created
        Hotel hotel = new Hotel(s);
	    Room room0 = new Room(6,10); //creates 4 rooms type "Room"
	    Room room1 = new Room(4,7.5);
	    Room room2 = new Room(2,15);
	    Room room3 = new Room(2,20);
	    RoomA room4 = new RoomA(4,40); //creates 4 rooms type "RoomA"
	    RoomA room5 = new RoomA(2,35);
	    RoomA room6 = new RoomA(3,33);
	    RoomA room7 = new RoomA(4,45.5);
	    RoomB room8 = new RoomB(4,50,10); //creates 3 rooms type "RoomB"
	    RoomB room9 = new RoomB(5,100,7.5); 
	    RoomB room10 = new RoomB(2,35,5);
	    RoomC room11 = new RoomC(4,10,2,5); //creates 2 rooms type "RoomC"
	    RoomC room12 = new RoomC(6,15,4,10);
	    RoomE room13 = new RoomE(2,100,10); //creates 1 room type "RoomD"
	    RoomD room14 = new RoomD(6,30); //creates 1 room type "RoomE"
	    hotel.addRoom(room0); 
		hotel.addRoom(room1);
		hotel.addRoom(room2);
		hotel.addRoom(room3);                                       
		hotel.addRoom(room4);
		hotel.addRoom(room5);
		hotel.addRoom(room6);
		hotel.addRoom(room7);
		hotel.addRoom(room8);
		hotel.addRoom(room9);
		hotel.addRoom(room10);
		hotel.addRoom(room11);
		hotel.addRoom(room12);
		hotel.addRoom(room13);
		hotel.addRoom(room14);
		return hotel;            //each room created is added to hotel using class "Hotel" method addRoom(Room)
    }
    public static String createName(){ //Method that creates random client's name 
       char[] clientName = new char[10];
		for(int j = 0 ,choise = 0;j<= 9;j++,choise =(choise == 0)?1:0){
		int letter = 0;
		int choise2 = rand.nextInt(5);
		switch (choise2){
		    case 0:letter = (choise == 0)?65:rand.nextInt(68-66) + 66;break;
		    case 1:letter = (choise == 0)?69:rand.nextInt(72-70) + 70;break;
		    case 2:letter = (choise == 0)?73:rand.nextInt(78-74) + 74;break;
		    case 3:letter = (choise == 0)?79:rand.nextInt(84-80) + 80;break;
		    case 4:letter = (choise == 0)?85:rand.nextInt(88-86) + 86;break;
		    case 5:letter = (choise == 0)?89:90;
		    break;
		  }
	    clientName[j] = (j== 4)?' ':(char)letter;
       }
       return String.valueOf(clientName);
    }
    public static Reservation createRandomReservation(){ //method that creates a random reservation as requested
       String clientName = Creator.createName();
	   int randArrivalDay = rand.nextInt(Creator.monDays-1)+1;
	   int randDays = rand.nextInt(Creator.monDays-randArrivalDay) + 1;
	   int randPeople = rand.nextInt(5) +1;
	   return new Reservation(clientName,randArrivalDay,randDays,randPeople);
    }
   public static int getMaxPeople(Hotel hotel){    //Method to find a hotel's maxPeople,meaning the maxPeople of the hotel's room with the most maxPeople
        int max=0;
        for(int i = 0;i <= hotel.getRoomArray().size() - 1;i++)
        if(hotel.getRoomArray().get(i).getMaxPeople()>max){
            max =hotel.getRoomArray().get(i).getMaxPeople();
        }
        return max;
    }
    public static boolean cancelRandomReservation25(Hotel hotel){ //method that implements 25% propability of cancellation as requested
        if(rand.nextInt(3) == 0){
	       int canc = rand.nextInt(hotel.getReservationArray().size());
	       
	       hotel.resCancellation(hotel.getReservationArray().get(canc).getResCode());
	       return true;
	   }
	   return false;
    }
    public static String createMenu(){ //method that creates the menu used in main
        String menu ="1.Next revision\n2.Add reservation\n3.Cancel reservation\n4.Projection of reservation\n5.Projection of rooms\n6.Plan Reservation Projection\n7.Income Projection\n8.Terminate\nSelect something:";
        return menu;
    }
    public static boolean isInt(String s){//Method to determine if is String is a Int or not
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public static String showReservations(Hotel hotel,String where){//Method to Show a diagram of the reservations as requested
        String S = new String();
        S += ("Reservation's Code\t|Client's Name\t|Room's Code\t\n");
	    for(int i = 0;i<= hotel.getReservationArray().size() -1;i++)
	     S += (hotel.getReservationArray().get(i).getResCode()+((!where.equals("GUI"))?"\t":"")+"\t\t|"+hotel.getReservationArray().get(i).getClientName()+"\t|"+hotel.getReservationArray().get(i).getRoom().getCode()+"\t\n");
	     System.out.println(S);
	     return S;
    }
    public static String showRooms(Hotel hotel,String where){//Method to Show a diagram of the Rooms as requested
        DecimalFormat formatter = new DecimalFormat("#.##"); 
        String S = new String();
        S = ("Room's Code"+((!where.equals("GUI"))?"":"\t")+"\t|Completeness"+((!where.equals("GUI"))?"":"\t")+"\t|Income\t\n");
	    for(int j = 0;j<= hotel.getRoomArray().size() -1;j++)
	    S+=(hotel.getRoomArray().get(j).getCode()+"\t\t|"+formatter.format(hotel.getRoomArray().get(j).completeness())+"%\t\t|"+hotel.getRoomArray().get(j).pricing()+"\t\n");
	    System.out.println(S);
	    return S;
    }
   }