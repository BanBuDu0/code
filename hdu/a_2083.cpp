#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int m;
    cin >> m
    while(m--){
        int n;
        cin >> n;
        int* p = new int[n];
        for(int i = 0; i < n; ++i){
            cin >> p[i];
        }
        sort(p, p + n);
        int m = p[n / 2];
        int res = 0;
        for(int i = 0; i < n; ++i){
            if(i == n / 2){
                continue;
            }else{
                res += abs(m - [i]);
            }
        }
        cout << res << endl;
    }
    return 0;
}