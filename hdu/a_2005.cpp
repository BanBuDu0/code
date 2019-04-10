#include<iostream>
#include<stdio.h>
using namespace std;

int main(int argc, char const *argv[])
{
    int a[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int year, month, day;
    while(scanf("%d/%d/%d", &year, &month, &day)){
        int res = 0;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && month > 2){
            ++res;
        }
        for(int i = 1; i < month; ++i){
            res += a[i];
        }
        res += day;
        printf("%d\n", res);
    }
    return 0;
}
