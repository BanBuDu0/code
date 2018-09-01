#include<iostream>
#include<string.h>
#include<algorithm>
using namespace std;

int a[10], b[10];
void add(string &n) {
    reverse(n.begin(), n.end());
    string rn = n;
    int flag = 0;
    for(int i = 0; i < (int)n.length(); i++) {
        n[i] = n[i] + rn[i] + flag - '0';
        flag = 0;
        if(n[i] > '9') {
            flag = 1;
            n[i] -= 10;
        }
        int p = n[i] -'0';
        ++a[p];

    }
    if(flag == 1) {
        n += '1';
    }
    reverse(n.begin(), n.end());
}

int main(int argc, char const *argv[]) {
    string n, n1;
    cin >> n;
    n1 = n;
    add(n);
    for(int i = 0; i < (int)n1.length(); ++i){
        int p = n1[i] - '0';
        ++b[p];
    }
    int flag = 0;
    for(int i = 0; i < 10; ++i){
        if(a[i] != b[i]){
            flag = 1;
        }
    }
    if(flag == 0){
        cout << "Yes" << endl;
    }else{
        cout << "No" << endl;
    }
    cout << n << endl;
    return 0;
}
