#include <stdio.h>
#include <stdlib.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>


int i=0;
int processesNumber=5000;//πληθος διεργασιων που θελουμε να δημιουργηθουν

	void nothing()
	{
	int x=0;
	x=x+1;
	}

int main()
{

time_t start_t; //ορισμος μεταβλητων time()
time_t end_t;
double xronos_t,mesosXronos_t;
time(&start_t);
	while(i<processesNumber)	//επανάληψη ώστε να δημιουργηθούν όσες διεργασίες θέλουμε
	{
	i++;
	int pid;
	nothing();
	pid=wait(NULL);		/*αναμονή μέχρι να δημιουργηθουν όσες διεργασίες θελουμε κια μετά να εκτελεστει ο πατέρας */
        pid=fork();
        if(pid<0){printf("Unsucessfull fork");
        exit(1);  
        }

	else if (pid==0) //Αν η διεργασία είναι παιδί εκτυπώνει κατάλληλο μήνυμα
        {
        printf("pid=%i ppid=%i Child:%i of %i \n",getpid(),getppid(),i,getppid());
        
	exit(0);
	
	}
	else if(pid>0 && i==processesNumber)  /*Αν δεν είναι παιδί και έχουν δημιουργηθεί όλες οι διεργασίες παιδιά ελεγχουμε αν εχουμε επιτυχία ή καποιο error*/
	{
	int status;
while((pid=wait(&status))>0){
	if(status==0)
	{printf("The child process finished successfully\n");}
	
	if(status==1)
        {printf("There was an error in finishing the child process\n");}
        }

}
	}
time(&end_t);
printf("Starting count of seconds: %li\n",start_t); //χρόνος έναρξης δημιουργίας εργασιων
printf("Final count of seconds: %li\n",end_t); //χρόνος ολοκλήρωσης δημιουργίας εργασιων
xronos_t=difftime(end_t,start_t); // συνολικός χρόνος εκτέλεσης
mesosXronos_t=xronos_t/i;// M.O. χρόνου εκτέλεσης
printf("The total time of execution of  %d  processes is : %f seconds \n ",i,xronos_t);
printf("The average time of execution of %d  processes is:(ending time-starting time)/%d= %f seconds\n ",i,i,mesosXronos_t);



return(0);
}
