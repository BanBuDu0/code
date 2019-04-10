#include<iostream>
#include<cstdio>
using namespace std;

int main(int argc, char const *argv[])
{
    int m, n;
    scanf("%d", &m);
    for(int i = 0; i < m; ++i){
        scanf("%d", &n);
        double res = 0;
        res += 1;
        for(int j = 2; j < n + 1; ++j){
            if(j % 2 == 0){
                res -= 1 / j;
            }else{
                res += 1 / j;
            }
        }
        printf("%.2lf\n", res);
    }
    return 0;
}