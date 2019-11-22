#ifndef RESERVATION_H
#define RESERVATION_H
#include <string>
class Room;
class Reservation
{
    public:
        Reservation(std::string clientName, int arrival,int days,int people);

        void setRoom(Room *room);
        std::string getClientName();
        int getResCode();
        int getArrival();
        int getDays();
        Room* getRoom();
        int getPeople();
    private:
     std::string clientName;
     int resCode;
     int arrival;
     int days;
     int people;
     Room *room ; //Object variables as requested by the pronunciation
     static int runningCode;//Class variable,runningCode to keep code positive and unique for each Room as requested by the pronunciation
};

#endif // RESERVATION_H
