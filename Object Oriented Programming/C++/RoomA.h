#ifndef ROOMA_H
#define ROOMA_H
#include "Room.h"


class RoomA : public Room
{
    public:
        RoomA(int maxPeople,double pricePerDay);
        virtual ~RoomA();
        double pricing();
        typedef Room super;
    protected:
      double pricePerDay;

};

#endif // ROOMA_H
