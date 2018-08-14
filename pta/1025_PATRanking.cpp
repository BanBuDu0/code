#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>
using namespace std;

typedef struct inf {
    char reg_n[14];
    int local_rank, location_number, score;
} inf;

bool cmp(inf a, inf b) {
    int i = strcmp(a.reg_n, b.reg_n);
    if(a.score == b.score){
        if(i < 0){
            return true;
        }else{
            return false;
        }
    }
    return a.score > b.score;
}

int main() {
    int n;
    cin >> n;
    vector<inf> a;
    int all = 0;
    inf temp;
    int index = 0;
    for(int i = 0; i < n ; i++) {
        int k;
        cin >> k;
        for(int j = 0; j < k; ++j) {
            cin >> temp.reg_n >> temp.score;
            temp.location_number = i + 1;
            a.push_back(temp);
        }
        sort(a.begin() + index, a.begin() + index + k, cmp);
        for(int j = index; j < index + k ; ++j) {
            if(a[j].score == a[j - 1].score && j > index) { //j > index 和下面的 i > 0 debug 找的我好辛苦啊
                a[j].local_rank = a[j - 1].local_rank;
            } else {
                a[j].local_rank = j - index + 1;
            }
        }
        index += k;
        all += k;
    }

    sort(a.begin(), a.end(), cmp);
    int j = 0;
    cout << all << endl;
    for(int i = 0; i < (int)a.size(); ++i) {
        if(a[i].score == a[i - 1].score && i > 0) {
            cout << a[i].reg_n << " "  << j << " " << a[i].location_number  << " " << a[i].local_rank << endl;

        } else {
            j = i + 1;
            cout << a[i].reg_n << " "  << j << " " << a[i].location_number  << " " << a[i].local_rank << endl;
        }
    }

    return 0;
}
