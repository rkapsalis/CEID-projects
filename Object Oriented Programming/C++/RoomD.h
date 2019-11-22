#ifndef ROOMD_H
#define ROOMD_H
#include <string>
#include "RoomA.h"
#include "Room.h"
#include "Reservation.h"
using namespace std;
class Reservation;
class RoomD : public RoomA
{
    public:
        RoomD(int maxPeople,double pricePerDay);
        virtual ~RoomD();
        typedef RoomA super;
        bool addReservation(Reservation *reservation);
        double pricing();
        bool cancellation(int reservCode);
        bool setDinner(Reservation *res,string s);


    private:
        string dinner[30];
        const static double breakfastPerDay;
	    const static double dinnerPerDay;

};

#endif // ROOMD_H
