#include<iostream>
#include<string>
#include<stdio.h>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    getchar();
    while(n--){

        string t;
        getline(cin, t);
        int a[5] = {0};
        for(int i = 0; i < t.size(); ++i){
            if(t[i] == 'a'){
                a[0] += 1;
            }else if(t[i] == 'e'){
                a[1] += 1;
            }else if(t[i] == 'i'){
                a[2] += 1;
            }else if(t[i] == 'o'){
                a[3] += 1;
            }else if(t[i] == 'u'){
                a[4] += 1;
            }
        }
        cout << "a:" << a[0] << endl;
        cout << "e:" << a[1] << endl;
        cout << "i:" << a[2] << endl;
        cout << "o:" << a[3] << endl;
        cout << "u:" << a[4] << endl;
        if(n > 0){
            cout << endl;
        }

    }
    return 0;
}
