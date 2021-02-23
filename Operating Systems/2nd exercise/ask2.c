#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include<unistd.h>
#include<sys/wait.h>

int main(){
int pid;
int x;

pid=getpid();
fflush(stdout); //καθαρισμος buffers
printf("parentid_confirm=%i ****This is the Father process that will have 4 Children****\n",pid); //επιβεβαιωση πατέρα
fflush(stdout);
        for(int i=0 ; i<4; i++)
        {

        wait(NULL);// αναμονή πατέρα ωστέ η fork να μην εκτελεστεί σε κάποιο παιδί
        pid=fork();
        fflush(stdout);
        if(pid<0){printf("Unsucessfull fork"); exit(0); } //περίπτωση αποτυχίας fork
        if (pid==0)
        {
        printf("pid=%i ppid=%i Child:%i of %i \n",getpid(),getppid(),i+1,getppid()); // εκτύπωση παιδιών,τα id  τους και το  id του πατέρα τους

        exit(0);
                }

        }
       for(int i=0; i<4; i++){
       int status;
       pid_t pid = wait(&status);
       }
return(0);
}
