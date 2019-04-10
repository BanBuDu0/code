#include<iostream>
#include<cstdio>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    while(scanf("%d %d", &n, &m) != EOF){
        int total = 0;
        for(int i = 1; i <= n; ++i){
            total += 2 * i;
            if(i % m ==0){
                printf(i > m ?" %d": "%d", total / m);
                total = 0;
            }
        }
        if(total != 0){
            printf(n / m > 0?" %d": "%d", total / (n % m));
        }
        cout << endl;
    }
}
