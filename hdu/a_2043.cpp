#include<iostream>
#include<string>
using namespace std;

int main(int argc, char const *argv[])
{
    int m;
    string t;
    cin >> m;
    while(m--){
        int a[4] = {0};
        cin >> t;
        if(t.size() < 8 || t.size() > 16){
            cout << "NO" << endl;
            continue;
        }
        for(int i = 0, len = t.size(); i < len; ++i){
            if(t[i] >= 'A' && t[i] <= 'Z'){
                ++a[0];
            }else if(t[i] >= 'a' && t[i] <= 'z'){
                ++a[1];
            }else if(t[i] > '0' && t[i] <= '9'){
                ++a[2];
            }else if(t[i]=='~' || t[i]=='!'||t[i]=='@'||t[i]=='#'|| t[i]=='$'|| t[i]=='%'|| t[i]=='^'){
                ++a[3];
            }
        }
        int flag = 0;
        for(int i = 0; i < 4; ++i){
            if(a[i] > 0){
                ++flag;
            }
        }
        if(flag >= 3){
            cout << "YES";
        }else{
            cout << "NO";
        }
        cout << endl;

    }
    return 0;
}