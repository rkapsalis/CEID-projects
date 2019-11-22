#include "Room.h"
#include "RoomC.h"
#include "Reservation.h"

RoomC::RoomC(int maxPeople,double price,int minPeople,int minDays)
:super(maxPeople,price)
{
     this->minDays= minDays;
     this->minPeople = minPeople;
}

RoomC::~RoomC()
{
    //dtor
}
 bool RoomC::addReservation(Reservation* reservation){                                    //Method to add Reservation to the running RoomC
        if(this->maxPeople < reservation->getPeople() || this->minPeople > reservation->getPeople() || this->minDays > reservation->getDays())
        {
            return false;
        }                              //It first checks if requested reservation's people exceeds running RoomC's maxPeople or eludes minPeople or minDays,

		try{
        for(int j = reservation->getArrival() - 1;j <=(reservation->getArrival() + reservation->getDays()-2);j++) //then the RoomC's reservationTable for possible entries
        if(this->reservTable[j] != NULL){
            return false;
        }                                                   //and in case of occupied days terminates the method by returning false
        for(int j = reservation->getArrival() - 1;j <=(reservation->getArrival() + reservation->getDays()-2);j++)  //If not it registers the reservation in each of the requested days
        this->reservTable[j] = reservation;
        reservation->setRoom(this);
        return true;                                // and terminates the method by returning true


    }catch(int e){
        return false;
    }

    }
