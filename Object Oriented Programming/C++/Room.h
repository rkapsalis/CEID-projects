#ifndef ROOM_H
#define ROOM_H
class Reservation;

class Room
{
    public:
        Room(int maxPeople,double price);
        bool virtual addReservation(Reservation *reservation);
        double virtual pricing();
        bool cancellation(int reservationCode);
        double completeness();
        int getCode();
        bool checkDay(int i);
        int getMaxPeople();
        virtual ~Room();
		bool operator+=(Reservation* reservation);
    protected:
         int maxPeople;
         Reservation* reservTable[30];//Object variables as requested by the pronunciation
    private:
        int code;
        double price;
        static int runningCode;
};

#endif // ROOM_H
