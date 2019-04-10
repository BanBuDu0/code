#include<iostream>
#include<math.h>
#include<stdio.h>
using namespace std;

int main(int argc, char const *argv[])
{
    double x1, y1, x2, y2;
    while(cin >> x1 >> y1 >> x2 >> y2){
        double c1 = x2 - x1;
        double c2 = y2 - y1;
        double res = sqrt(c1 * c1 + c2 * c2);
        printf("%.2lf\n", res);
        // cout <<  res << endl;
    }
    return 0;
}
