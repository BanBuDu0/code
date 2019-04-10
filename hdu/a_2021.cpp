#include<iostream>
#include<stdio.h>
using namespace std;

int main(int argc, char const *argv[]) {
    int n;
    while(cin >> n && n!=0) {
        int res = 0;
        int* a = new int[n];
        int b,c,d,e,g,f;
        for(int i=0; i<=n-1; i++) {
            scanf("%d",&a[i]);
            b=a[i]/100;
            c=(a[i]-b*100)/50;
            d=(a[i]-b*100-c*50)/10;
            e=(a[i]-b*100-c*50-d*10)/5;
            f=(a[i]-b*100-c*50-d*10-e*5)/2;
            g=(a[i]-b*100-c*50-d*10-e*5-2*f)/1;
            res+=b+c+d+e+f+g;
        }
        printf("%d\n",res);
    }
    return 0;
}
