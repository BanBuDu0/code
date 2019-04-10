#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    long long a[41] = {0, 3, 8};
    int n;
    for(int i = 0; i < 41; ++i){
        a[i] = 2 * (a[i - 1] + a[i - 2]);
    }
    while(cin >> n){
        cout << a[n] << endl;
    }
    return 0;
}