#include "Reservation.h"
#include "Room.h"
#include <iostream>
using namespace std;
int Reservation::runningCode = 1;
Reservation::Reservation(string clientName,int arrival,int days,int people)
:room(NULL)
{
    this->resCode = runningCode++;
    this->clientName = clientName;
    this->arrival = arrival;
    this->days = days;
    this->people = people;
}
//Class constructor,defining running Reservation's resCode by ascending order and clientName,arrival,days and people by programmer's definition

    void Reservation::setRoom(Room *room){
        this->room = room;
    }          //Method to set room for the running Reservation(room is private,and direct access is prohibited from other classes)
    string Reservation::getClientName(){
        return clientName;
    }
    int Reservation::getResCode(){
        return resCode;
    }
    int Reservation::getArrival(){
        return arrival;
    }
    int Reservation::getDays(){
        return days;
    }
    Room* Reservation::getRoom(){
        return room;
    }
    int Reservation::getPeople(){
        return people;
    }          //Methods to return resCode,clientName,arrival,days,room and people values from the running Reservation(they are all private and direct access is prohibited from other classes)

