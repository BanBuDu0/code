#include<iostream>
#include<vector>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    vector<int> map[n];
    for(int i = 0; i < m; ++i){
        int n1, n2;
        cin >> n1 >> n2;
        map[n1].push_back(n2);
    }
    int copNum;
    cin >> copNum;
    for(int i = 0; i < copNum; ++i){
        int node;
        cin >> node;
        if(map[node].size() != n){
            cout << "NO" << endl;
        }else{
            cout << "YES" << endl;
        }
    }

}