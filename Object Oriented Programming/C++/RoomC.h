#ifndef ROOMC_H
#define ROOMC_H
#include "Reservation.h"
#include "Room.h"


class RoomC : public Room
{
    public:
        RoomC(int maxPeople,double price,int minPeople,int minDays);
        virtual ~RoomC();
        typedef Room super;
        bool addReservation(Reservation* reservation);
    protected:

    private:
        int minPeople;
        int minDays;
};

#endif // ROOMC_H
