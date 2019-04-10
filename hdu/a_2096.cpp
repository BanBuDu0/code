#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int t;
    cin >> t;
    int a, b;
    while(t--){
        cin >> a >> b;
        int res = ((a % 100) + (b % 100)) % 100;
        cout << res << endl;
    }
    return 0;
}