#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    while(cin >> n >> m){
        cout << '+';
        for(int i = 0; i < n; ++i){
            cout << '-';
        }
        cout << '+' << endl;
        for(int i = 0; i < m; ++i){
            cout << '|';
            for(int i = 0; i < n; ++i){
                cout << ' ';
            }
            cout << '|' << endl;
        }
        cout << '+';
        for(int i = 0; i < n; ++i){
            cout << '-';
        }
        cout << '+' << endl << endl;
    }
    return 0;
}