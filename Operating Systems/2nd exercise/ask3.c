#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include<unistd.h>
#include<sys/wait.h>


int main()
{
int i;
int pid;
for (i=0; i<5; i++)
{
	pid=fork();
	if (pid > 0) 
	{
	printf("The  father's Id is: %i,  The current process Id is: %i,  The child's Id is: %i\n", getppid(), getpid(), pid);
	wait(NULL);
	break;
	}
}
	return (0);
}
