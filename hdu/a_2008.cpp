#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int count;
    while(cin >> count && count != 0){
        int n = 0, z = 0, p = 0;
        double t;
        for(int i = 0; i < count; ++i){
            cin >> t;
            if(t == 0){
                ++z;
            }else if(t > 0){
                ++p;
            }else{
                ++n;
            }
        }
        cout << n << " " << z << " " << p << endl;
    }
    return 0;
}