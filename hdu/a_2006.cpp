#include<iostream>
using namespace std;
int main(int argc, char const *argv[])
{
    int count;
    while(cin >> count){
        int t, res = 1;
        for(int i = 0; i < count; ++i){
            cin >> t;
            if(t % 2 == 1){
                res *= t;
            }
        }
        cout << res << endl;
    }
    return 0;
}