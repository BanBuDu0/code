#include<iostream>
#include<cmath>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    while(cin >> n >> m && (n != 0 || m != 0)){
        for(int i = sqrt(2.0 * m);i > 0; --i){
            int a = (m - i * (i - 1) / 2) / i;
            if(m == a * i  + (i - 1) * i / 2 && a > 0){
                cout<<'['<<a<<','<<a+i-1<<']'<<endl;
            }
        }
        cout << endl;
    }
    return 0;
}
