#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    int a[51] = {0, 3, 6, 6};
    for(int i = 4; i < 51; ++i){
        a[i] = a[i - 1] + a[i - 2] * 2;
    }
    while(cin >> n){
        cout << a[i] << endl;
    }
    return 0;
}