#include<iostream>
#include<math.h>
#include<stdio.h>
using namespace std;

#define PI 3.1415927
int main()
{
    double r;
    while(cin >> r){
        double res = 4.0/3 * PI * r * r * r;
        printf("%.3lf\n", res);
    }
    return 0;
}
