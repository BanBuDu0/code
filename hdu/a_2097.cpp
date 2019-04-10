#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int num;
    while(cin >> num && num != 0){
        int reg[3] = {0};
        int t = num;
        while(t){
            reg[0] += t % 10;
            t /= 10;
        }
        t = num;
        while(t){
            reg[1] += t % 16;
            t /= 16;
        }
        t = num;
        while(t){
            reg[2] += t % 12;
            t /= 12;
        }
        if(reg[0] == reg[1] && reg[0] == reg[2]){
            cout << num << " is a Sky Number." << endl;
        }else{
            cout << num << " is not a Sky Number." << endl;
        }
    }
    return 0;
}
