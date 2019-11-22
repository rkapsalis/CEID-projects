#include "RoomA.h"
#include <iostream>
using namespace std;

RoomA::RoomA(int maxPeople,double pricePerDay)
 :super(maxPeople,0)
{
  this->pricePerDay = pricePerDay;
}//Class constructor,defining maxPeople and pricePerDay

RoomA::~RoomA()
{
    //dtor
}
double RoomA::pricing()      //Method to find the sum of the price of the combined registered RoomA's Reservations.
     {
        double cost = 0;    //Method Variable to keep track of the amount
        for(int i=0; i<30; i++)         //The loop scans for not empty entries
        {
            if(reservTable[i] != NULL){
                 cost += pricePerDay;    //When it finds them it adds the pricePerDay
            }
        }
        return cost;           //And terminates the method by returning the cost after scanning the whole table
}
