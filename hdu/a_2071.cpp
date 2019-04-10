#include<iostream>
#include<cstdio>
using namespace std;

int main(int argc, char const *argv[])
{
    int t, n;
    cin >> t;
    while(t--){
        cin >> n;
        double temp, h = 0;
        for(int i = 0; i < n; ++i){
            scanf("%lf", &temp);
            if(temp > h){
                h = temp;
            }
        }
        printf("%.2lf\n", h);
    }
    return 0;
}
