#include<iostream>
#include<string>
using namespace std;

int main(int argc, char const *argv[])
{
    string t;
    while(cin >> t){
        char max = t[0];
        for(int i = 0; i < t.size(); ++i){
            if(t[i] > max){
                max = t[i];
            }
        }
        string res = "";
        int index = 0, long = 0;
        for(int i = 0; i < t.size(); ++i){
            ++long;
            if(t[i] == max){
                res += t.substr(index, long);
                res += "(max)";
                index = i + 1;
                long = 0;
            }
        }

    }
    return 0;
}