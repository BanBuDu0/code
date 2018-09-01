#include <iostream>
#include<vector>
using namespace std;

struct su {
    int num;
    int radix;
};

int main()
{
    int m = 0;
    int n = 0;
    vector<su> my;
    while(cin >> m && m >= 0){
        su temp;
        temp.num = m;
        cin >> n;
        temp.radix = n;
        my.push_back(temp);
    }
    for(int i = 0;i < 100; i++){
        cout << my[i].num <<" "<< my[i].radix << endl;
    }
    return 0;
}