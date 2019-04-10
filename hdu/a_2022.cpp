#include<iostream>
#include<cmath>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]) {
    int n, m;
    while(cin >> n >> m) {
        long long temp;
        int x, y;
        long long res = 0;
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                cin >> temp;
                if(abs(temp) > abs(res)) {
                    x = i;
                    y = j;
                    res = temp;
                }
            }
        }
        cout << x << " " << y << " " << res << endl;
    }
    return 0;
}
