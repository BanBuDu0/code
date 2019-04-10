#include<iostream>
using namespace std;

int cow(int n){
    if(n < 5){
        return n;
    }else{
        return cow(n - 1) + cow(n - 2);
    }
}

int main(int argc, char const *argv[])
{
    int n, res = 0;
    while(cin >> n && n != 0){
        cout << cow(n) << endl;
    }
    return 0;
}