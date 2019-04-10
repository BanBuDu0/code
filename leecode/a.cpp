#include<iostream>
#include<set>
#include<vector>
using namespace std;

int main(int argc, char const *argv[])
{
    int n, m;
    int t1, t2;
    set<int> mapNode;
    cin >> n >> m;
    for(int i = 0; i < m; ++i){
        cin >> t1 >> t2;
        mapNode.insert(t1);
        mapNode.insert(t2);
    }
    set<int>::iterator it;
    vector<int> nums;
    for(it=mapNode.begin();it!=mapNode.end();it++)
    {
        nums.push_back(*it);
    }
    int c;
    cin >> c;
    for(int i = 0; i < c; ++i){
        int tm;
        cin >> tm;
        set<int> coverNode;
        for(int j = 0; j < tm; ++j){

            cin >> t1 >> t2;
            coverNode.insert(t1);
            coverNode.insert(t2);
        }
        if(coverNode.size() != mapNode.size()){
            cout << "No" << endl;
            continue;
        }
        vector<int> compe;
        for(it=mapNode.begin();it!=mapNode.end();it++)
        {
            compe.push_back(*it);
        }
        for(int k = 0; k < nums.size(); ++k){
            if(compe[k] != nums[k]){
                cout << "No"<< endl;
                break;
            }
        }
        cout << "Yes" << endl;
    }
    return 0;
}