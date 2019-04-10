#include<iostream>
#include<string>
using namespace std;

void zero(string &a){
    if(a.find('.') != string::npos){
        for(int i = a.size() - 1; i >= a.find('.'); --i){
            if(a[i] == '0'){
                a.erase(i);
            }else if(a[i] == '.'){
                a.erase(i);
                break;
            }else{
                break;
            }
        }
    }
}

int main(int argc, char const *argv[])
{
    string a, b;
    while(cin >> a >> b){
        zero(a);
        zero(b);
        if(a.compare(b) == 0){
            cout << "YES";
        }else{
            cout << "NO";
        }
        cout << endl;
    }
    return 0;
}