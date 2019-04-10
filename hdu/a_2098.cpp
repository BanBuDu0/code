#include<iostream>
#include<vector>
using namespace std;
int main(int argc, char const *argv[])
{
    int n;
    int a[10001] = {0};
    a[2] = 1;
    a[3] = 1;
    for(int i = 4; i < 10001; ++i){
        int flag = 0;
        for(int j = 2; j < i; ++j){
            if(i % j == 0){
                flag++;
            }
        }
        if(flag == 0){
            a[i] = 1;
        }
    }
    while(cin >> n && n != 0){
        int res = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if((a[i] + a[j] == n )&& a[i] == 1 && a[j] == 1){
                    ++res;
                }
            }
        }
        cout << res << endl;
    }
    return 0;
}