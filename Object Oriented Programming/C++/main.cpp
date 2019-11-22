#include <time.h>
#include <string.h>
#include <iostream>
#include <stdlib.h>
#include "Reservation.h"
#include "Room.h"
#include "RoomA.h"
#include "RoomB.h"
#include "RoomC.h"
#include "RoomD.h"
#include "RoomE.h"
#include "Hotel.h"
#include <sstream>

using namespace std;
void println() {
	cout << endl;
}
template <typename type>
void println(type e) {
	cout<<e<<endl;
}
template <typename type>
void print(type e) {
	cout << e;
}
template <typename type>
void read(type& e) {
	cin >> e;
}
string to_string(int i) {
	stringstream o;
	o << i;
	return o.str();
}

int main() {
	Hotel hotel("Adonis");
	Room *room0 = new Room(6, 10); //creates 4 rooms type "Room"
	Room *room1 = new Room(4, 7.5);
	Room *room2 = new Room(2, 15);
	Room *room3 = new Room(2, 20);
	RoomA *room4 = new RoomA(4, 40); //creates 4 rooms type "RoomA"
	RoomA *room5 = new RoomA(2, 35);
	RoomA *room6 = new RoomA(3, 33);
	RoomA *room7 = new RoomA(4, 45.5);
	RoomB *room8 = new RoomB(4, 50, 10); //creates 3 rooms type "RoomB"
	RoomB *room9 = new RoomB(5, 100, 7.5);
	RoomB *room10 = new RoomB(2, 35, 5);
	RoomC *room11 = new RoomC(4, 10, 2, 5); //creates 2 rooms type "RoomC"
	RoomC *room12 = new RoomC(6, 15, 4, 10);
	RoomE *room13 = new RoomE(2, 100, 10); //creates 1 room type "RoomE"
	RoomD *room14 = new RoomD(6, 30); //creates 1 room type "RoomD"

	hotel += room0;
	hotel += room1;
	hotel += room2;
	hotel += room3;
	hotel += room4;
	hotel += room5;
	hotel += room6;
	hotel += room7;
	hotel += room8;
	hotel += room9;
	hotel += room10;
	hotel += room11;
	hotel += room12;
	hotel += room13;
	hotel += room14;
//each room created is added to hotel using overloaded operator +=
	int choise;
	string answer;
	srand(time(NULL));

	do {
		//Random Reservation
		char clientName[10];
		for (int j = 0, choise = 0; j <= 9; j++, choise = (choise == 0) ? 1 : 0) {
			int letter = 0;
			int choise2 = rand()%6;
			switch (choise2) {
			case 0:letter = (choise == 0) ? 65 : rand()%(68 - 66 + 1) + 66; break;
			case 1:letter = (choise == 0) ? 69 : rand()%(72 - 70 + 1) + 70; break;
			case 2:letter = (choise == 0) ? 73 : rand()%(78 - 74 + 1) + 74; break;
			case 3:letter = (choise == 0) ? 79 : rand()%(84 - 80 + 1) + 80; break;
			case 4:letter = (choise == 0) ? 85 : rand()%(88 - 86 + 1) + 86; break;
			case 5:letter = (choise == 0) ? 89 : 90; break;
			}
			clientName[j] = (j == 4) ? ' ' : (char)letter;
		}
		string name;
		for (int i = 0; i < 10; i++)
			name.push_back(clientName[i]);
		int randArrivalDay = rand()%(30) + 1;
		int randDays = rand()%(30 - randArrivalDay + 1) + 1;
		int randPeople = rand()%(6) + 1;
		Reservation* randRes = new Reservation(name,randArrivalDay,randDays,randPeople);
		hotel += randRes;
		if (rand()%(4) == 0) {
			int canc = rand()%((int)hotel.getReservationArray().size());
			hotel - hotel.getReservationArray().at(canc);
		}
		//Menu
		println("1.Next revision");
		println("2.Add reservation ");
		println("3.Cancel reservation");
		println("4.Projection of reservation");
		println("5.Projection of rooms");
		println("6.Plan Reservation Projection");
		println("7.Income Projection");
		println("8.Terminate");
		println("Select something:");
        read(choise);
		string client;
			switch (choise) {
			case 1:break;
			case 2:
			{
				print("Give client's name:");
				read(client);
				print("Give arrival day:");
				int arrivalDay;
				read(arrivalDay);
				print("Give days:");
				int days;
				read(days);
				print("Give people:");
				int people;
				read(people);
				Reservation* res1 = new Reservation(client, arrivalDay, days, people);
				print("Do you want to give room code?(Y/N):");
				read(answer);
				if (!(answer.compare("Y") && answer.compare("y") && answer.compare("yes"))) {
					print("Give room code:");
					int roomCode;
					read(roomCode);
					hotel.roomAddReservation(res1, roomCode);
				}
				else {
					hotel.addReservation(res1);
				}
				break;
			}
			case 3:
				print("Give code:");
				int code;
				read(code);
				hotel.resCancellation(code);
				break;
			case 4:
				println("Reservation's Code\t|Client's Name\t|Room's Code\t");
				for (int i = 0; i <= (int)hotel.getReservationArray().size() - 1; i++)
					println(to_string(hotel.getReservationArray().at(i)->getResCode()) + "\t\t\t|" + hotel.getReservationArray().at(i)->getClientName() + "\t|" + to_string(hotel.getReservationArray().at(i)->getRoom()->getCode()) + "\t");
				break;
			case 5:
				println("Room's Code\t|Completeness\t\t|Income\t");
				for (int j = 0; j <= (int)hotel.getRoomArray().size() - 1; j++)
					println(to_string(hotel.getRoomArray().at(j)->getCode()) + "\t\t\t|" + to_string(((int)(hotel.getRoomArray().at(j)->completeness()/0.01))*0.01) + "%\t\t|" + to_string(hotel.getRoomArray().at(j)->pricing()) + "\t");
				break;
			case 6:
				hotel.reservPlan();
				break;
			case 7:
				print("Do you want to give room code?(Y/N):");
				read(answer);
				if (!(answer.compare("Y") && answer.compare("y") && answer.compare("yes"))) {
					print("Give code:");
					int roomCode;
					read(roomCode);
					print("The income is " + to_string(hotel.incomeCalc(roomCode)));
				}
				else {
					println("The income is " + to_string(hotel.incomeCalc()));
				}
				break;
			case 8:
				break;
			default:
				print("Invalid option,do you want to continue?(Y/N):");
				read(answer);
				if (!(answer.compare("Y") && answer.compare("y") && answer.compare("yes"))) {
					break;
				}
				else {
					choise = 8;
					break;
				}
			}

	} while (choise != 8);

	return 0;
}

