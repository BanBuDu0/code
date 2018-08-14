#include<iostream>
#include<vector>
using namespace std;

//pat 运行超时，使用scanf和printf 代替 cin, cout
int moore(vector<int>& nums) {
    int m;
    int count = 0;
    for (int i = 0; i < nums.size(); i++) {
        if (count == 0) {
            m = nums[i];
            count++;
        } else if (nums[i] == m) {
            count++;
        } else
            count--;
    }
    return m;
}
int main() {
    int m, n;
    cin >> m >> n;
    vector<int> color;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int l;
            cin >> l;
            color.push_back(l);
        }
    }
    cout << moore(color);
}
