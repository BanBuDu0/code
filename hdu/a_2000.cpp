#include<iostream>
using namespace std;

int main(){
    char a, b, c, temp;
    while(cin >> a >> b >> c){
        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }
        if(c < a){
            temp = c;
            c = b;
            b = a;
            a = temp;
        }else if(c > a && c < b){
            temp = c;
            c = b;
            b = temp;
        }
        cout << a << " " << b << " " << c << endl;
    }
}