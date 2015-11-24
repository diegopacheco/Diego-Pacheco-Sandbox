#include <stdio.h>


#ifndef NUM
#define NUM 10
#endif 

int main(void){
  
   int n;
   int val = 1;

   printf("C code! N = %d \n",NUM);
   for(n=0;n<=NUM;n++){
      printf("\t%3d \t %6d\n",n,val);
      val = 2*val;
   }
  
   return 0;
	
}

