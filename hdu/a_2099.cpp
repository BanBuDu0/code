#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int a, b;
    while(cin >> a >> b && (a != 0 || b != 0)){
        a *= 100;
        int flag = 0;
        for(int i = 0; i < 100; ++i){
            a += i;
            if(a % b == 0){
                printf(flag == 0?"%d":" %d", i);
                flag = 1;
            }
        }
        cout << endl;
    }
}