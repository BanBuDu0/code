#include<iostream>
#include<string>
using namespace std;

int main(int argc, char const *argv[])
{
    string t;
    while(getline(cin, t)){
         t[0] -= 32;
         for(int i = 0; i < t.size(); ++i){
            while(t[i] == ' '){
                ++i;
                t[i] -= 32;
            }

         }
         cout << t << endl;
    }

    return 0;
}
