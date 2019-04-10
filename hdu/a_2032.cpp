#include<iostream>
#include<cstdio>
using namespace std;

int main(){
    int res[30][30];
    res[0][0] = 1;
    res[1][0] = 1;
    res[1][1] = 1;
    int n;
    while(cin >> n){
        if(n > 2){
            for(int i = 2; i < n; ++i){
                res[i][0] = 1;
                res[i][i] = 1;
                for(int j = 1; j < i; ++j){
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                }
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i + 1; ++j){
                printf(j == 0?"%d":" %d", res[i][j]);
            }
            cout << endl;
        }
        cout << endl;
    }
}
