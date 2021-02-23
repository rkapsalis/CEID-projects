#include <stdio.h>          /* printf()                 */
#include <stdlib.h>         /* exit(), malloc(), free() */
#include <sys/types.h>      /* key_t, sem_t, pid_t      */
#include <sys/wait.h>
#include <time.h>
#include <sys/shm.h>        /* shmat(), IPC_RMID        */
#include <errno.h>          /* errno, ECHILD            */
#include <semaphore.h>      /* sem_open(), sem_destroy(), sem_wait().. */
#include <fcntl.h>          /* O_CREAT, O_EXEC          */
#include <string.h>
#include <unistd.h>

#define  ONE       1

typedef sem_t     Semaphore;

Semaphore *mutex;                 /*      synch semaphore      */ /*shared */


int main ()
{

   char *str1;
    int i;                        /* loop variables            */
    char *t;					      /* temporary variable        */
    key_t shmkey;                 /* shared memory key         */
    int shmid;                    /* shared memory id          */
    pid_t pid;                    /* fork pid                  */
    char *p;                       /* shared variable           */ /*shared */
    unsigned int n;               /* fork count                */
    unsigned int value;           /* semaphore value           */
    int *nSeconds;                /* Dynamic array             */
								  /* stores the number of secs */
								  /* the i-process waits       */
	     char buffer[50]; 
     
    /* Initializes random number generator */								  
	srand(time(NULL));
								  
    /********************************************************/								       
    /* Initialize a shared variable in shared memory        */
    /* valid directory name and a number                    */
    shmkey = ftok ("/dev/null", 6);       
    shmid = shmget (shmkey,1000*sizeof(char), 0644 | IPC_CREAT);

	/* shared memory error check */
    if (shmid < 0)                           
    {
        perror ("shmget\n");
        exit (1);
    }
    /********************************************************/  


    



    /********************************************************/								       
	/* attach p to shared memory */
    p  = (char *) shmat (shmid, NULL, 0);   
    *p = 0; 

    /********************************************************/

    printf ("How many children do you want to fork?\n");
    printf ("Fork count: ");
    scanf  ("%u", &n);

    /********************************************************/								       



    /* initialize semaphores for shared processes */
    mutex = sem_open ("pSem", O_CREAT | O_EXCL, 0644, ONE); 

	/* Dynamic array which stores the number of secs */
	/* the i-process will wait                       */
    nSeconds = (int *)malloc(n * sizeof(int));
    
    for (i=0; i<n; i++) nSeconds[i] = rand()%4 + 1;
    /********************************************************/

    /* fork child processes */
    for (i = 0; i < n; i++)
    {
        wait(NULL);  /* child execute with specific order, in order text to make sense when reading */ 
        pid = fork ();
     
	    if (pid < 0) {
        /* check for error      */
            sem_unlink ("pSem");   
            sem_close(mutex);  

            /* unlink prevents the semaphore existing forever */
            /* if a crash occurs during the execution         */
            printf ("Fork error.\n");
        }
        else if (pid == 0) /* child processes */
            break;                  
    }


    /******************************************************/
    /******************   PARENT PROCESS   ****************/
    /******************************************************/
    if (pid > 0)
	{
        /* wait for all children to exit */
        while (pid = waitpid (-1, NULL, 0))
        {
            if (errno == ECHILD)
                break;
        }

        printf (" Parent: All children have exited.\n");
		printf (" *p = %c\n\n\n", *p);
		
        /* shared memory detach */
        shmdt (p);
        shmctl (shmid, IPC_RMID, 0);

        /* unlink prevents the semaphore existing forever */
        /* if a crash occurs during the execution         */
        sem_unlink ("pSem");   
        sem_close(mutex);  
    }
    /******************************************************/
    /******************   CHILD PROCESS   *****************/
    /******************************************************/
    else
	{
        sem_wait (mutex);           /* DOWN operation */

        
	    printf (" Child(%d) enters the critical section.\n", i);
        printf (" Waiting %d seconds.\n", nSeconds[i]);
        
        t = p;
        
        str1= "this is child";    /* text of child[i] */
        sprintf(buffer, "I am child %d ",i);
        
        strcat(t,buffer);         /* concatenate */
        sleep (nSeconds[i]);
        p = t;
        
        
		printf (" Child(%d) exits the critical region\n", i);
		printf (" new value of *p=%s.\n\n\n", p);
		
		
        sem_post (mutex);           /* UP operation */
    }
    exit (0);
}
