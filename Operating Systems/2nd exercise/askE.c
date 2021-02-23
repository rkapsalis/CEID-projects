#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>      /* key_t, sem_t, pid_t      */
#include <sys/shm.h>        /* shmat(), IPC_RMID        */
#include <errno.h>          /* errno, ECHILD            */
#include <semaphore.h>      /* sem_open(), sem_destroy(), sem_wait().. */
#include <fcntl.h>          /* O_CREAT, O_EXEC          */
#include <unistd.h>
 #include <sys/wait.h>

typedef sem_t Semaphore; 
Semaphore *s1;
Semaphore *s2;
int main(){
    int   i;                        /*      loop variables  */
    pid_t pid[5];                   /*      fork pid        */
    int child_status;
	
	s1 = sem_open ("Sem1", O_CREAT | O_EXCL, 0644, 0); 
    s2 = sem_open ("Sem2", O_CREAT | O_EXCL, 0644, 0); 
	for (i=0; i<5; i++)
    {	
        pid[i] = fork();

        if (pid[i] == 0) 
	{
           break;
        }
    }
	
	if (pid[0] == 0){
		system("ls -l");
		sem_post (s1); 
		
	}
	else if (pid[0] != 0 && pid[1] == 0){
		system("ps -l");
		sem_post (s2); 
		
	}
	else if (pid[0] != 0 && pid[1] != 0 && pid[2] == 0){
		sem_wait(s1);
		sem_wait(s2);		
		system("pwd");
		sem_post (s2);
		
	}
	else if (pid[0] != 0 && pid[1] != 0 && pid[2] != 0 && pid[3] == 0){
		sem_wait(s2);
		system("whoami");
		sem_post(s1);
		sem_post (s2);
	}
	else if (pid[0] != 0 && pid[1] != 0 && pid[2] != 0 && pid[3] != 0 && pid[4] == 0){
		  sem_wait(s1);
		 sem_post (s2);
		  system("df -h");
	}
	else
   {
	for (i = 0; i < 5; i++)
	{
	    pid_t wpid = waitpid(pid[i], &child_status, 0);

	    if (WIFEXITED(child_status))
            {
               printf("Child: %d terminated with exit status %d\n", wpid, WEXITSTATUS(child_status));
            }
            else
            {
               printf("Child: %d terminate abnormally\n", wpid);
            }
        }

        printf(" Parent unlinks the semaphores\n Bye\n");

        /* unlink prevents the semaphore existing forever */
        /* if a crash occurs during the execution         */
        sem_unlink ("Sem1");   
        sem_close(s1);  
        sem_unlink ("Sem2");   
        sem_close(s2);            
    }
}
