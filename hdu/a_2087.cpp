#include<iostream>
#include<string>
using namespace std;

int main(int argc, char const *argv[]) {
    string s;
    while(cin >> s && s !="#") {
        string a;
        cin >> a;
        int i = 0, j = 0, len1 = s.size(), len2 = a.size(), k = i;
        int res = 0;
        while(i < len1) {
            if(s[i] == a[j] && j < len2 && i < len1) {
                ++i;
                ++j;
                if(j == len2) {
                    ++res;
                    j = 0;
                    i = ++k;
                }
            } else {
                j = 0;
                i = ++k;
            }

        }
        cout << res<< endl;
    }
    return 0;
}
