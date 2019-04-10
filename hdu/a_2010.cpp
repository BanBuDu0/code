#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int m, n;
    while(cin >> m >> n){
        int flag = 0, output_flag = 0;
        for(int i = m; i <=n; ++i){
            int a, b, c;
            c = i % 10;
            b = (i / 10) % 10;
            a = (i / 100) % 10;
            int t = a * a * a +  b * b * b + c * c * c;
            if(t == i){
                if(output_flag == 0){
                    cout << t;
                    output_flag = 1;
                    flag = 1;
                }else{
                    cout << " " << t;
                }
            }else{
                continue;
            }
        }
        if(flag == 1){
            cout << endl;
        }else{
            cout << "no" << endl;
        }


    }
    return 0;
}
