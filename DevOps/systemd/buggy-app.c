#include <stdio.h>
#include <unistd.h>
#include <time.h>

void process(void);
void printTime(void);
void writeToDisk(void);

int main(){
  process();
  return 0;
}

void process(){
     while(1){
       sleep(2);
       writeToDisk();
     }
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
