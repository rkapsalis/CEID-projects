#ifndef HOTEL_H
#define HOTEL_H
#include "Room.h"
#include "Reservation.h"
#include <vector>
using namespace std;
class Hotel
{
    public:
        Hotel(string hotelName);
        virtual ~Hotel();
        vector<Room*> roomArray;
        vector<Reservation*> reservationArray;
         void addRoom(Room *room);
         bool temp;
         Room* codeRoomRetrieval(int code);
         Reservation*  codeReservationRetrieval(int code);
         bool  roomAddReservation(Reservation *res,int code);
         double incomeCalc(int rCode);
         bool resCancellation(int code);
         double incomeCalc();
         string reservPlan();
         int  addReservation(Reservation *res);
         vector<Room*>  getRoomArray();
         vector<Reservation*> getReservationArray();
		 void operator+=(Room* room);
		 int operator+=(Reservation* res);
		 bool operator-(Reservation* res);


    private:
        string hotelName;
};

#endif // HOTEL_H
