#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    while(cin >> n){
        int res = 1;
        for(int i = 1; i < n; ++i){
            res = (res + 1) * 2;
        }
        cout << res << endl;
    }
    return 0;
}