#ifndef ROOMB_H
#define ROOMB_H
#include "Room.h"
#include "RoomA.h"
#include "Reservation.h"
class Reservation;

class RoomB : public RoomA
{
    public:
        RoomB(int maxPeople, double pricePerDay, double discountPerDay);
	    double pricing();
	    bool cancellation(int code);
	    typedef RoomA super;
    protected:
       double discountPerDay;

};

#endif // ROOMB_H
