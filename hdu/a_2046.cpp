#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    long long a[51] = {0, 1, 2, 3};
    for(int i = 4; i < 51; ++i){
        a[i] = a[i - 1] + a[i - 2];
    }
    while(cin >> n){
        cout << a[n] << endl;
    }
    return 0;
}