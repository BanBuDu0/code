#include<iostream>
#include<cstdio>
using namespace std;
struct numCount
{
    int num;
    int c;
};

int main(int argc, char const *argv[])
{
    int n;
    while(scanf("%d", &n) != EOF && n != 0){
        numCount* t = new numCount[n];
        for(int i = 0; i < n; ++i){
            t[i].c = 0;
        }
        for(int i = 0; i < n; ++i){
            scanf("%d", &t[i].num);
            t[i].c++;
        }
        for(int i = 0; i < n; ++i){
            cout << t[i].c;
        }
        for(int i = 0; i < n; ++i){
            if(t[i].c % 2 != 0){
                printf("%d\n", t[i].num);
            }
        }

    }
    return 0;
}
