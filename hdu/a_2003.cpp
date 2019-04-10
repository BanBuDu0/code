#include<iostream>
#include<math.h>
#include<stdio.h>
using namespace std;

int main()
{
    double r;
    while(cin >> r){
        if(r < 0){
            r = -r;
        }
         printf("%.2lf\n", r);
    }
    return 0;
}
