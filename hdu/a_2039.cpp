#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]) {
    int m;
    double a[3];
    cin >> m;
    while(m--) {
        for(int i = 0; i < 3; ++i) {
            cin >> a[i];
        }
        if(a[0] + a[1] > a[2] && a[0] + a[2] > a[1] && a[2] + a[1] > a[0]) {
            cout << "YES";
        } else {
            cout << "NO";
        }
        cout << endl;
    }
    return 0;
}
