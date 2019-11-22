#include "Room.h"
#include "Reservation.h"
#include <iostream>
int Room::runningCode = 1;
Room::Room(int maxPeople,double price)
{   for(int i= 0; i<30;i++){
    this->reservTable[i] = NULL;}
    this->code = runningCode++;
    this->maxPeople = maxPeople;
    this->price = price;
}

Room::~Room()
{
    //dtor
}
bool Room::operator+=(Reservation* reservation)
{
	return this->addReservation(reservation);
}
bool Room::addReservation(Reservation *reservation) {
	 if (this->maxPeople < reservation->getPeople()) {
            return false;
     }                                      //It first checks if requested reservation's people exceeds running Room's maxPeople,
	 try {
		 for (int j = reservation->getArrival() - 1; j <= (reservation->getArrival() + reservation->getDays() - 2); j++) //then the Room's reservationTable for possible entries
			 if (this->reservTable[j] != NULL) {
                    return false; }                                                   //and in either case terminates the method by returning false
		 for (int j = reservation->getArrival() - 1; j <= (reservation->getArrival() + reservation->getDays() - 2); j++) //If not it registers the reservation in each of the requested days
			 this->reservTable[j] = reservation;                                                        // registers the Room in the reservation and terminates the method by returning true
		 reservation->setRoom(this);
		 return true;
	 }
	 catch (int e) {
		 return false;
	 }

 }
 double Room::pricing()//Method to find the sum of the price of the combined registered Room's Reservations
    {
        double cost = 0; //Method Variable to keep track of the amount
        for(int i=0; i<30; i++){
            if(reservTable[i]!= NULL){                       //The loop scans for not empty entries
                cost += price * reservTable[i]->getPeople();    //When it finds them it adds the product of the Room's price per person and the number of the Reservation's persons
            }
        }
        return cost;                                         //And terminates the method by returning the cost after scanning the whole table
    }
  bool Room::cancellation(int reservationCode){        //Method to cancel a reservation,based on it's code in the running Room's
        for(int k=0; k<30; k++){
            if(reservTable[k]!= NULL){                       //First it scans the Table for entries
            if(this->reservTable[k]->getResCode() == reservationCode){  //If it finds them it checks if they have the requested code
            this->reservTable[k] = NULL;                               //If they fulfil both cases it replaces them with null
        }
        }
        }
         return true;                                           //Having or not cancelled any reservations it terminates the program by returning true
    }
 double Room::completeness()
    {
        double notEmpty = 0;  //Method variable to keep track of the not empty rooms
        double percent;       //Method variable to calculate the percent of completeness
         for(int i=0; i<30; i++){             //Method to find the completeness percentage of the combined registered Reservations.
            if(reservTable[i]!= NULL){       //The loop scans for not empty entries
                notEmpty++;                 //When it finds them it increases the local variable notEmpty by one,keeping truck of the taken rooms
            }
        }
        percent = (notEmpty/30)*(double)100;         //Then it calculates the percentage
        return percent;                                      //and terminates the method by returning it
    }
 int Room::getCode(){
        return this->code;
    }                  //Method to return the value of the code of the running Room
 bool Room::checkDay(int i){
        return ((this->reservTable[i] == NULL)?false:true);
    } //Method to check if the requested day is occupied in the running Room's Table
 int Room::getMaxPeople(){
        return this->maxPeople;
    }//Method to return the value of the people of the running Room
