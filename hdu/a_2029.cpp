#include<iostream>
#include<string>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    while(cin >> n){
        while(n--){
            string s;
            cin >> s;
            int i = 0, j = s.size() - 1;
            int flag = 0;
            while(i < j){
                if(s[i] != s[j]){
                    flag = 1;
                    break;
                }
                ++i, --j;
            }
            if(flag == 1){
                cout << "no" << endl;
            }else{
                cout << "yes" << endl;
            }
        }
    }
    return 0;
}
