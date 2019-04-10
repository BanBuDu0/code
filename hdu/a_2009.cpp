#include<iostream>
#include<stdio.h>
#include<math.h>
using namespace std;

double getSum(int n, int m){
    double t = n;
    double res = 0;
    res += n;
    for(int i = 1; i < m; ++i){
        t = sqrt(t);
        res += t;
    }
    return res;
}

int main(int argc, char const *argv[])
{
    int n, m;
    while(cin >> n >> m){
        double res = getSum(n, m);
        printf("%.2lf\n", res);
    }
    return 0;
}
