#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int t, n;
    char y;
    while(t--){
        cin >> y >> n;
        if(y >= 'A' && y <= 'Z'){
            cout << y - 'A' + 1 + n << endl;
        }else{
            cout << -(y - 'A' + 1) + n << endl;
        }
    }
    return 0;
}