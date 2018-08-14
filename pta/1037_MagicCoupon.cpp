#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool comp(int i, int j){
    return i > j;
}

int main() {
    int nc, np;
    long int n; // 牛客的测试用例不使用long int 会超Int的范围
    vector<int> pos_ncs;
    vector<int> neg_ncs;
    vector<int> pos_nps;
    vector<int> neg_nps;
    cin >> nc;
    for(int i = 0; i < nc; ++i) {
        cin >> n;
        if(n > 0) {
            pos_ncs.push_back(n);
        } else {
            if(n != 0) {
                neg_ncs.push_back(n);
            }
        }
    }
    cin >> np;
    for(int i = 0; i < np; ++i) {
        cin >> n;
        if(n > 0) {
            pos_nps.push_back(n);
        } else {
            if(n != 0) {
                neg_nps.push_back(n);
            }
        }
    }

    sort(pos_ncs.begin(), pos_ncs.end(), comp);
    sort(pos_nps.begin(), pos_nps.end(), comp);
    sort(neg_ncs.begin(), neg_ncs.end());
    sort(neg_nps.begin(), neg_nps.end());
    int pos_length = min((int)pos_ncs.size(), (int)pos_nps.size());
    int neg_length = min((int)neg_ncs.size(), (int)neg_nps.size());

    n = 0;
    for(int i = 0; i < pos_length; ++i) {
        n += pos_ncs[i] * pos_nps[i];
    }
    for(int i = 0; i < neg_length; ++i) {
        n += neg_ncs[i] * neg_nps[i];
    }
    cout << n << endl;
    return 0;
}
