#include "RoomB.h"
#include <iostream>
#include "Reservation.h"
using namespace std;
class Reservation;
RoomB::RoomB(int maxPeople, double pricePerDay, double discountPerDay)
 :super(maxPeople,pricePerDay)
{
	this -> discountPerDay = discountPerDay;
} //Class constructor,defining maxPeople,pricePerDay and discountPerDay

double RoomB::pricing()
{
  double cost = 0; //Method variable to keep track of the amount
  int curCode = 0; //Method variable to give the reservation code
  int on = 0; //Method variable to count the number of reservation days
  bool exceed = false; //Method variable to check if it is the first time that it exceeds the disqount limit requested by the pronunciation
  for (int i = 0; i < 30; i++) {  //The loop scans for not empty entries
	  if (this->reservTable[i] != NULL) {
		  if (curCode != this->reservTable[i]->getResCode()) {
			  curCode = this->reservTable[i]->getResCode();
			  on = 0;
			  exceed = false;
		  }
		  else { on++; }
		  if (on*discountPerDay >= pricePerDay / 2) { exceed = true; }
		  cost +=((exceed == false)?(pricePerDay - on*discountPerDay):(pricePerDay/2));
	  }
  }
  return cost;
}

bool RoomB::cancellation(int code)
{
	return false;
}//Method to override the cancellation method of the class Room,as requested by the pronunciation
