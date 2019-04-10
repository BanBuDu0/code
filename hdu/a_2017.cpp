#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    for(int i = 0; i < n; ++i){
        string t;
        int count = 0;
        cin >> t;
        for(int j = 0; j < t.size(); ++j){
            if(t[j] >= '0' && t[j] <= '9'){
                ++count;
            }
        }
        cout << count << endl;

    }
    return 0;
}
