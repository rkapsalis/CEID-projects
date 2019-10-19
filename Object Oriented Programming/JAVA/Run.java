import java.util.Scanner;
import java.text.DecimalFormat;
public class Run {
	public static void main(String[] args) {
	    Hotel hotel = Creator.createHotel("Hotel Lakis");
		String choice0 = new String();
		String answer = new String();
		
	   do{
	   hotel.addReservation(Creator.createRandomReservation());
       Creator.cancelRandomReservation25(hotel); // 25% propability of cancellation
	   System.out.print(Creator.createMenu()); //menu of options as requested
       Scanner scan = new Scanner(System.in);
       choice0 = scan.nextLine(); //scans user's answer
		 switch (choice0){ //checks user's answer and does the scheluded actions
		  case "1": 
		  break;
		  case "2": 
		     System.out.print("Give clint's name:");
			 String client = scan.nextLine();
		     System.out.print("Give arrival day:");
			 int arrivalDay= scan.nextInt();
		     System.out.print("Give days:");
			 int days= scan.nextInt();
			 System.out.print("Give people:");
			 int people= scan.nextInt();
			 Reservation res1 = new Reservation(client,arrivalDay,days,people);
			 scan.nextLine();
			 System.out.print("Do you want to give room code?(Y/N):");
			 answer = scan.nextLine();
			  if(answer.equals("Y")||answer.equals("y")||answer.equals("yes")){
			      System.out.print("Give room code:");
			      int roomCode= scan.nextInt();
				  hotel.roomAddReservation(res1,roomCode);
				  }
			  else{
				  hotel.addReservation(res1);  
			  }
			  break;
		  case "3":
		     System.out.print("Give code:");
			 int code = scan.nextInt();
			 hotel.resCancellation(code);
			 break;
		  case "4":
			 Creator.showReservations(hotel,"terminal");
			 break;
		  case "5":
			 Creator.showRooms(hotel,"terminal");
             break;
		  case "6":   
		  hotel.reservPlan(); //calls the reservPlan() method from the class Hotel, in order to print the hotel's room array
		  break;
		  case "7":
		     System.out.print("Do you want to give room code?(Y/N):");
			 answer = scan.nextLine();
			  if(answer.equals("Y")||answer.equals("y")||answer.equals("yes")){
				  System.out.print("Give code:");
			      int roomCode= scan.nextInt();
				  System.out.println("The income is " + hotel.incomeCalc(roomCode));
				  }
			  else{
				 System.out.println("The income is "+hotel.incomeCalc()); 
			  }			
			  break;
		  case "8": 
		  break;
		  default:
		  System.out.print("Invalid option,do you want to continue?(Y/N):");
		  answer = scan.nextLine();
		  if(answer.equals("Y")||answer.equals("y")||answer.equals("yes")){ //if user wants to continue, loop runs again, else the program is terminated
		      break;}
		  else{
			  choice0 = "8";
			  break;}	
		 }
		}while(!choice0.equals("8")); // loop ends when the user select to terminate the program
	}

}
	   
