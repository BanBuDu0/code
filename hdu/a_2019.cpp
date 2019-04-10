#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    while(cin >> n >> m && (n != 0 || m != 0)){
        int* v = new int[n + 1];
        for(int i = 0; i < n; ++i){
            cin >> v[i];
        }
        v[n] = m;
        sort(v, v + n + 1);
        cout << v[0];
        for(int i = 1; i < n + 1; ++i){
            cout << " " << v[i];
        }
        cout << endl;
    }
    return 0;
}
