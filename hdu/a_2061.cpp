#include<iostream>
#include<string>
#include<cstdio>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, k;
    string temp;
    cin >> n;
    while(n--){
        cin >> k;
        double t1, t2, sum1 = 0, sum2 = 0, flag = 0;
        for(int i = 0; i < k; ++i){
            cin >> temp;
            cin >> t1 >> t2;
            if(t2 < 60){
                flag = 1;
            }
            sum1 += t1 * t2;
            sum2 += t1;
        }
        double res = sum1 *1.0/sum2;
        if(flag == 0){
            printf("%.2lf\n", sum1 *1.0/sum2);
        }else{
            cout << "Sorry!" << endl;
        }
        if(n){
            cout << endl;
        }

    }
    return 0;
}
