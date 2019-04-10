#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    int a[100], b[100];
    while(cin >> n >> m && (n != 0 || m != 0)){
        vector<int> res;
        int flag = 0;
        for(int i = 0; i < n; ++i){
            cin >> a[i];
        }
        for(int i = 0; i < m; ++i){
            cin >> b[i];
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(a[i] == b[j]){
                    flag = 1;
                }
            }
            if(flag == 0){
                res.push_back(a[i]);
            }
            flag = 0;
        }
        int len = res.size();
        if(len == 0){
            cout << "NULL" << endl;
        }else{
            sort(res.begin(), res.end());
            for(int i = 0; i < res.size(); ++i){
                cout << res[i] << " " ;
            }
            cout << endl;
        }

    }
}
