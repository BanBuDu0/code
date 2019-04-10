#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    while(cin >> n){
        int grades = (int *)malloc(sizeof(int) * (n + 1));
        for(int i = 0; i < n; ++i){
            grades[i];
        }
        sort(grades, grades + n);
        double total = 0;
        for(int i = 1; i < n - 1; ++i){
            total += grades[i];
        }
        printf("%.2lf\n", total / n);

    }
    return 0;
}