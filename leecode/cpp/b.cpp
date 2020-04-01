#include<iostream>
#include<vector>
using namespace std;

#define MaxSize 10000
typedef struct{
    int edge[MaxSize][MaxSize];
    int vexnum, arcnum;
}MGraph;

int main(int argc, char const *argv[])
{
    MGraph p;
    memset(p.edge,0,sizeof(p.edge));
    cin >> p.vexnum >> p.arcnum;
    for(int i = 0; i < p.vexnum; ++i){
        int n, m;
        cin >> n >> m;
        p.edge[n][m] = 1;
    }
    int c;
    cin >> c;
    for(int i = 0; i < c; ++i){
        int tn;
        cin >> tn;
        vector<int> tempV;
        for(int j = 0; j < tn; ++j){
            int t;
            cin >> t;
            tempV.push_back(t);
        }
        for(int m = 0; m < tempV.size(); ++m){
            for(int n = m + 1; n < tempV.size(); ++n){
                if(p.edge[tempV[m]][tempV[n]] == 1){
                    cout << "Not an Independent Set" << endl;
                    break;
                }
            }
        }
        cout << "Yes" << endl;
    }

    return 0;
}
