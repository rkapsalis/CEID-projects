#include <stdio.h>
#include <stdlib.h>
int main(){

int pid;
int x,y;
x=10;
y=10;

pid=fork();
if(pid!=0){x++; y--;}

printf("x=%i y=%i \n",x,y);

pid=fork();
if(pid!=0){x++; y--;}

printf("x=%i y=%i \n",x,y);

return (0);
}
