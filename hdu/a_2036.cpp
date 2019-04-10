#include<iostream>
#include<cmath>
#include<cstdio>
using namespace std;

int main(){
    int n;
    int x[100], y[100];
    while(cin >> n && n != 0){
        for(int i = 0; i < n; ++i){
            cin >> x[i] >> y[i];
        }
        int temp = 0;
        for(int i = 0; i < n; ++i){
            if(i < n - 1){
                temp += x[i] * y[i + 1] - x[i + 1] * y[i];
            }else{
                temp += x[i] * y[0] - x[0] * y[i];
            }

        }
        printf("%.1lf\n", (double)0.5 * abs(temp));
    }
}
