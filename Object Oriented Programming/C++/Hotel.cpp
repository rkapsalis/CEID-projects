#include "Hotel.h"
#include <iostream>
#include <vector>
#include <sstream>
using namespace std;
string tostring(int i) {
	stringstream o;
	o << i;
	return o.str();
}
Hotel::Hotel(string hotelName)
{
  this->hotelName=hotelName;
}

Hotel::~Hotel()
{
    //dtor
}
    void Hotel::addRoom(Room *room){  //Method to add a Room to the running's hotel Room Array

         roomArray.push_back(room);

    }
    Room* Hotel::codeRoomRetrieval(int code){     //Method to retrieve a Room based on room's code from the running's hotel Room Array
         for(int i = 0;i <= (int)this->roomArray.size() - 1;i++)
         if(this->roomArray.at(i)->getCode() == code){
             return this->roomArray.at(i);
         }
         return NULL;
     }
    Reservation*  Hotel::codeReservationRetrieval(int code){ //Method to retrieve a Reservation based on room's code from the running's hotel Reservation Array
         for(int i = 0;i <= (int)this->reservationArray.size() - 1;i++)
         if(this->reservationArray.at(i)->getResCode() == code){
             return this->reservationArray.at(i);
            }
         return NULL;
     }
      bool  Hotel::roomAddReservation(Reservation *res,int const code){ //Method to add a reservation to the running hotel's Reservation Array given the Reservation and the Room's code
         Room *room = this->codeRoomRetrieval(code); //It retrieves the Room and it registers it to a method variable(Room)
         bool flag = false;//Method variable to determine if the reservation was a success
         if(room != NULL) //it first checks if the Room was retrieved successfully
           flag = *room+=res;  //And tries to add the reservation,setting to the flag the result
         if(flag == true){
             cout<<"Reservation " << res->getResCode() <<" was made with success in Room " << code<<endl;
             this->reservationArray.push_back(res);
            }
         else{
             cout<<"Reservation "<< res->getResCode() << " was failed to register in the Room " << code<<endl;
            }//Based on the result it shows the suitable messages and terminates the program by returning the flag
         return flag;
        }
     int  Hotel::addReservation(Reservation *res){   //Method to add a Reservation to the running's hotel Reservation Array given only the Reservation and registering it to the first available Room
           for(int i = 0;i <= (int)this->roomArray.size() - 1;i++){ //It scans the running's hotel Room Array and checks if the reservation can be made
           if(this->roomAddReservation(res,this->roomArray.at(i)->getCode()) == true){
               return this->roomArray.at(i)->getCode();
            } //If yes it adds to the success message the room code and terminates the program by returning it
           else{
               continue;
            }
         }
           return 0;//if not it terminates the program returning 0 as requested by the pronunciation
     }
     bool Hotel::resCancellation(int code){  //Method to cancel a reservation based on reservation's code
            Reservation *res = this->codeReservationRetrieval(code);//It retrieves the Reservation and it registers it to a method variable(Reservation)
			int cod = res->getRoom()->getCode();
            if(res != NULL){ //it first checks if the Reservation was retrieved successfully
				if (res->getRoom()->cancellation(code) == true) { //If yes it checks if the cancellation can be done
					for (int i = 0; i <= (int)this->reservationArray.size() - 1; i++) {
						if (this->reservationArray.at(i)->getResCode() == code) {
							cout << "Reservation " << code << " in Room " << cod << " cancelled"<<endl;
							this->reservationArray.erase(reservationArray.begin() + i);
							return true;
						}//If yes it removes the Reservation from the running hotel's Reservation Array printing the suitable message and terminating the method
					}
				}
           }
            cout<<"Reservation " <<code << " cancellation was unsuccessful"<<endl; //If either of the two cases was false it prints the suitable unsuccessful message and terminates the method
            return false;
     }
     double  Hotel::incomeCalc(){ //Method to calculate the whole income from all the Rooms combined
           double cost = 0; //Method Variable to keep track of the amount
           for(int i = 0;i <= (int)this->roomArray.size() - 1;i++){
                cost += this->roomArray.at(i)->pricing(); //It scans the running's hotel Reservation Array and it adds the amount to the method variable using the Room's pricing() methods
           }
		   cost += this->roomArray.at(0)->pricing();
           return cost; //And when it is done it terminates the method by returning the whole amount
     }
     string Hotel::reservPlan() //Method to graphically represent the Reservations for all the running's hotel Rooms
        {
            string S;
            cout<< "Room";
            for(int i = 0;i<29;i++){
            cout<<((i+1<10)?((string)"\t0"+tostring(i+1)):((string)"\t"+tostring(i+1)));
        }
        cout << ((string)"\t"+tostring(30))<<endl;
         for(int i = 0;i <= (int)this->roomArray.size() - 1;i++){
        cout << ("\n");
        cout << (this->roomArray.at(i)->getCode());
        for(int j = 0;j<30;j++)
           // S.append(((string)"\t").append((this->roomArray.at(i)->checkDay(j) == true) ? "*" : "_"));
        cout << ("\t"+(string)((this->roomArray.at(i)->checkDay(j) == true)?"*":"_"));
        }
		 cout << endl;
        return S;
     }
    double Hotel::incomeCalc(int rCode){//Method to return the running's hotel room's income based in its code
    	 Room *room1 = this->codeRoomRetrieval(rCode);//It first creates a temporary room that stores the room that retrieved
    	if(room1!=NULL){
    		return room1->pricing();
    	 } //if it exists it returns its pricing
    	else{
    		return 0;
    	}//If not,0
     }
       vector<Room*>  Hotel:: getRoomArray(){
         return roomArray;
     }
    vector<Reservation*> Hotel::getReservationArray(){
         return reservationArray;
     }
     //operators overloading
	void Hotel::operator+=(Room* room)
	{
		this->addRoom(room);
	}
	int Hotel::operator+=(Reservation * res)
	{
		return this->addReservation(res);
	}
	bool Hotel::operator-(Reservation* res)
	{
		int cod = res->getResCode();
		return this->resCancellation(cod);
	}
	//Methods to return the running's hotel Arrays

