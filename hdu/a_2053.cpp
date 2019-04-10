#include<iostream>
#include<cstdio>
using namespace std;
int main(int argc, char const *argv[])
{
    int n, k;
    while(cin >> n){
        k=0;
        for(int i = 1;i <= n;i++){
            if(n % i == 0){
                k++;

            }
        }
        printf("%d\n",k%2);

    }
    return 0;
}
