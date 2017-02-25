#include <stdio.h>

int sum(int a, int b);
void process(void);
void segfault(void);

int main(){
    process();
    segfault();
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

void segfault(){
  int a[10];
  a[11] = 100;
}
