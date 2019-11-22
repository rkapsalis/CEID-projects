#include "RoomD.h"
#include <iostream>
#include <string>
using namespace std;

const double RoomD::breakfastPerDay = 5;
const double RoomD::dinnerPerDay = 10;

RoomD::RoomD(int maxPeople,double pricePerDay)
:super(maxPeople,pricePerDay)
{
for (int i = 0; i < 30; i++)
		 this->dinner[i] = "no";

}

RoomD::~RoomD()
{
    //dtor
}
bool RoomD::addReservation(Reservation *reservation){ //Overwrites the Room's method to determine during the Reservation's registration if the user wants dinner or not
	string answer;

	if (this->maxPeople < reservation->getPeople()) {
		return false;
	}                                      //It first checks if requested reservation's people exceeds running Room's maxPeople,
	try {
		for (int j = reservation->getArrival() - 1; j <= (reservation->getArrival() + reservation->getDays() - 2); j++) //then the Room's reservationTable for possible entries
			if (this->reservTable[j] != NULL) {
				return false;
			}                                                   //and in either case terminates the method by returning false
		for (int j = reservation->getArrival() - 1; j <= (reservation->getArrival() + reservation->getDays() - 2); j++) //If not it registers the reservation in each of the requested days
			this->reservTable[j] = reservation;                                                               // registers the Room in the reservation
		reservation->setRoom(this);
	}
	catch (int e) {
		return  false;
	}

		for (int j = reservation->getArrival() - 1; j <= (reservation->getArrival() + reservation->getDays() - 2); j++)
		this->reservTable[j] = reservation;
		reservation->setRoom(this);


	     cout<<"Do you want dinner?"<<endl;
         cin >> answer;  //It asks if the client wants dinner
   for(int i = reservation->getArrival()-1;i<=reservation->getArrival() - 1 + reservation->getDays();i++)
      this->dinner[i] = answer;                          //And saves the answer

          return true;                                //Finally it terminates the program
       }



double RoomD::pricing()//Overwrites the default method to calculate the cost of the dinner and the breakfast

  {
       double cost = 0;

   for(int i=0; i<30; i++){

    if(this->reservTable[i] != NULL){

			cost = cost + pricePerDay + breakfastPerDay*(reservTable[i]->getPeople()) + ((((this->dinner[i])).compare("yes") == 0) ? dinnerPerDay*(reservTable[i]->getPeople()) : 0);

  }
        }
return cost;

 }


bool RoomD::cancellation(int reservCode){//Overwrites the Room's method to cancel the dinner during the cancellation of the reservation

     for(int k=0; k<30; k++){

  if(reservTable[k]!= NULL){
             //First it scans the Table for entries

  if(this->reservTable[k]->getResCode() == reservCode){
//If it finds them it checks if they have the requested code

       this->reservTable[k] = NULL;
       //If they fulfil both cases it replaces them with null

        this->dinner[k] = "no";
 }

}

  }

return true;

 }
bool RoomD::setDinner(Reservation *res,string s){

        bool flag = false;

    for(int k=0; k<30; k++)

  if(reservTable[k] != NULL)
          if(res->getResCode() == reservTable[k]->getResCode()){
              dinner[k] = s;
			  flag =true;
            }

 return flag;
        }

