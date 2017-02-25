#include <stdio.h>

int sum(int a, int b);
void process(void);

int main(){
    process();
    return 0;
}

void process(){
   int a, b, result;
   printf("Enter two integers: ");
   scanf("%d %d", &a, &b);
   result = sum(a,b);
   printf("%d + %d = %d \n\r", a, b, result);
}

int sum(int a, int b){
  return a + b;
}
