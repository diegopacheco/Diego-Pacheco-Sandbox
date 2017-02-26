#include <stdio.h>
#include <unistd.h>
#include <time.h>

void process(void);
void printTime(void);
void writeToDisk(void);
void introduce_bug(void);

int main(){
  process();
  return 0;
}

void process(){
     int i = 0;

     while(1){
        sleep(2);
        writeToDisk();
        if (i==5){
           //introduce_bug();
        }else{
           i++;
        }
     }
}

void introduce_bug(){
    char c[20]="11";
    c[30] = 100; // this make the program crash :D
}

void writeToDisk(){
    FILE *fp;
    fp=fopen("/tmp/buggy-app.log", "a+");

    char x[23]="\n\rits all good I think ";
    fwrite(x, sizeof(x[0]), sizeof(x)/sizeof(x[0]), fp);

    time_t t = time(NULL);
    struct tm *tm = localtime(&t);
    char s[25];
    strftime(s, sizeof(s), "%c", tm);
    fwrite(s, sizeof(s[0]), sizeof(s)/sizeof(s[0]), fp);
    printf("%s\n", s);

    fclose(fp);
}

void printTime(){
  time_t rawtime;
  struct tm * timeinfo;
  time ( &rawtime );
  timeinfo = localtime ( &rawtime );
  printf ( "Current local time and date: %s", asctime (timeinfo) );
}
