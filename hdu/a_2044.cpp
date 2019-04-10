#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, a, b, temp;
    long long t[51];
    t[1] = 0;
    t[2] = 1;
    t[3] = 2;
    for(int i = 4; i < 51; ++i){
        t[i] = t[i - 1] + t[i - 2];
    }
    cin >> n;
    while(n--){
        cin >> a >> b;
        if(a < b)
        {
            temp = a;
            a = b;
            b = temp;
        }
        cout << t[a - b + 1] << endl;
    }
    return 0;
}
