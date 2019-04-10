#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, a;
    cin >> n;
    while(n--){
        cin >> a;
        int res = 3;
        for(int i = 0; i < a; ++i){
            res = (res - 1) * 2;
        }
        cout << res << endl;
    }
    return 0;
}
