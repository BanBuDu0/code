#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    cin >> n;
    int a[41];
    a[0] = 0;
    a[1] = 0;
    a[2] = 1;
    a[3] = 2;
    for(int i = 4; i < 41; ++i){
        a[i] = a[i - 1] + a[i - 2];
    }
    while(n--){
        cin >> m;
        cout << a[m] << endl;
    }
    return 0;
}