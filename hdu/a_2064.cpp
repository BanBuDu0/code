#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    long long a[36] = {0, 2, 36};
    for(int i = 3; i < 36; ++i){
        a[i] = a[i - 1] * 3 + 2;
    }
    while(cin >> n){
        cout << a[n] << endl;
    }
    return 0;
}