#include<iostream>
#include<string>
#include<cstdio>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    getchar();
    while(n--){
        string s;
        getline(cin, s);
        int res = 0;
        for(int i = 0; i < s.size(); ++i){
            if(s[i] > 255 || s[i] < 0){
                ++res;
            }
        }
        cout << res/2 << endl;
    }
    return 0;
}
