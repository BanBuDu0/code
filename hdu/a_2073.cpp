#include<iostream>
#include<cmath>
using namespace std;

double getLength(int x, int y){
    int i, s = x + y;
    double sum = s*(s-1)*sqrt(2)/2;
    sum += x * sqrt(2); 
    for(i = s; i > 0; i--)        
        sum += sqrt((i-1)*(i-1) + i*i);
    return sum;
}

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    int x1, y1, x2, y2;
    while(n--){
        cin >> x1 >> y1 >> x2 >> y2;
        printf("%.3lf\n", abs(getLength(x1, y1) - getLength(x2, y2)));
    }
    return 0;
}