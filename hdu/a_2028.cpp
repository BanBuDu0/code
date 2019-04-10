#include<iostream>
#include<string>
#include<stdio.h>
using namespace std;


int divisor(int a, int b){
    if(a % b == 0){
        return b;
    }else{
        return divisor(b, a % b);
    }
}

int main(int argc, char const *argv[])
{
    int n;
    while(cin >> n){
        long long a, b;
        cin >> a;
        for(int i = 1; i < n; ++i){
            a = a * b / divisor(a, b);
        } 
        cout << a;
    }
    return 0;
}
