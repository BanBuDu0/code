#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int m;
    cin >> m;
    while(m--){
        int a, b;
        cin >> a >> b;
        int compare1 = 0, compare2 = 0;
        for(int i = 1; i < a; ++i){
            if(a % i == 0){
                compare1 += i;
            }
        }
        for(int i = 1; i < b; ++i){
            if(b % i == 0){
                compare2 += i;
            }
        }
        if(compare1 == b && compare2 == a){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }
    }

    return 0;
}
