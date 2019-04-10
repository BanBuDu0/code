#include<iostream>
using namespace std;

int main(int argc, char const *argv[]) {
    int x, y;
    while((cin >> x >> y) && (x != 0 || y != 0)) {
        int flag = 0, temp;
        if(x > y) {
            temp = x;
            x = y;
            y = temp;
        }
        for(int i = x; i <= y; ++i) {
            int t = i * i + i + 41;
            for(int j = 2; j < t; ++j) {
                if(t % j == 0) {
                    flag = 1;
                }
            }
        }
        if(flag == 0) {
            cout << "OK" << endl;
        } else {
            cout << "Sorry" << endl;
        }
    }
    return 0;
}
