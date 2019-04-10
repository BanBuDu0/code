#include<iostream>
#include<cstdio>
using namespace std;

int main(){
    int n, r;
    int num[100];
    while(cin >> n >> r){
        int flag = 0;
        if(n < 0){
            flag = 1;
            n = -n;
        }
        int i = 0;
        while(n > 0){
            num[i++] = n % r;
            n /= r;
        }
        if(flag == 1){
            cout << "-";
        }
        for(int j = i - 1; j >= 0; --j){
            if(num[j] >= 10){
                printf("%c", num[j] - 10 + 'A');
            }else{
                cout << num[j];
            }
        }
        cout << endl;
    }
}
