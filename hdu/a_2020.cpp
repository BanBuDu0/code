#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

bool cmp(int i, int j){
    return abs(i) > abs(j);
}

int main(int argc, char const *argv[])
{
    int n;
    while(cin >> n && n != 0){
        int* t = new int[n];
        for(int i = 0; i < n; ++i){
            cin >> t[i];
        }
        sort(t, t + n, cmp);
        cout << t[0];
        for(int i = 1; i < n; ++i){
            cout << " " << t[i];
        }
        cout << endl;
    }
    return 0;
}
