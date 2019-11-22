#ifndef ROOME_H
#define ROOME_H
#include "RoomB.h"

class RoomE : public RoomB
{
    public:
        RoomE(int maxPeople,double pricePerDay,double discountPerDay);
        virtual ~RoomE();
        typedef RoomB super;
        bool cancellation(int reservationCode);
        double pricing();
    protected:

    private:
         static double extraCharges;
};

#endif // ROOME_H
