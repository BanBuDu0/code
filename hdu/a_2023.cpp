#include<iostream>
#include<cmath>
#include<cstdio>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]) {
    int n, m;
    while(cin >> n >> m) {
        double* everyAvClass = new double[m];
        vector<vector<int> > data(n,vector<int>(m));
        double* everyAvMan = new double[n];
        for(int i = 0; i < n; ++i){
            int sum = 0;
            for(int j = 0; j < m; ++j){
                int temp;
                cin >> temp;
                sum += temp;
                data[i][j] = temp;
            }
            everyAvMan[i] = (double)sum/m;
        }
        for(int i = 0; i < n; ++i){
            printf(i==0?"%.2lf":" %.2lf", everyAvMan[i]);
        }
        cout << endl;
        for(int i = 0; i < m; ++i){
            int sum = 0;
            for(int j = 0; j < n; ++j){
                sum += data[j][i];
            }
            everyAvClass[i] = (double)sum / n;
        }
        for(int i = 0; i < m; ++i){
            printf(i==0?"%.2lf":" %.2lf", everyAvClass[i]);
        }
        cout << endl;
        int res = 0;
        for(int i = 0; i < n; ++i){
            int flag = 1;
            for(int j = 0; j < m; ++j){
                if(data[i][j] < everyAvClass[j]){
                    --flag;
                }
            }
            if(flag == 1){
                ++res;
            }
        }
        cout << res << endl << endl;
    }
}
