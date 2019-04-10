#include<iostream>
using namespace std;

int main(){
    int a, b;
    while(cin >> a >> b && (a != 0 || b != 0)){
        int res = 1;
        while(b--){
            res = res * a % 1000;
        }
        cout << res << endl;
    }
}