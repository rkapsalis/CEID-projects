#include "RoomE.h"
double RoomE::extraCharges = 0;//Class variable to keep track of the cancellation()'s incomes
RoomE::RoomE(int maxPeople,double pricePerDay,double discountPerDay)
:super(maxPeople,pricePerDay,discountPerDay)
{
    //ctor
}//Class constructor,defining maxPeople,pricePerDay and discountPerDay

RoomE::~RoomE()
{
    //dtor
}
  bool RoomE::cancellation(int reservationCode)//Method to overwrite the cancellation() method from the class RoomB
    {
        RoomE* room1 = new RoomE(this->maxPeople,this->pricePerDay,this->discountPerDay);
		for (int i = 0; i < 30; i++)
			room1->reservTable[i] = this->reservTable[i]; //Method variable to copy the running room so it will be uneffected by the cancellation() changes
        bool cancel = ((RoomA*)this)->cancellation(reservationCode); //Method variable to check if the cancellation can be made,and if yes it mades it
        if(cancel == true){
          for(int i = 0;i<30;i++)
		  {
			  if (room1->reservTable[i] != NULL) {
				  if (room1->reservTable[i]->getResCode() != reservationCode)
					  room1->reservTable[i] = NULL;                                //It empties in the running RoomE's copy all the reservation that is not of the requested code
			  }
		  }
         extraCharges = room1->pricing() /2;                     //And then calculates the extra Pricing by calling the pricing() of the copy(as RoomB),as it has no other reservations
    }
    delete room1;
    return cancel;
}
double RoomE:: pricing()  //Method to overwrite the pricing method of the class RoomB that calculates and the extraCharges from previous cancellations
    {
        return(RoomB::pricing() + extraCharges);
    }
