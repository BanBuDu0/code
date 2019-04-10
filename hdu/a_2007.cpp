#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int left, right, temp;
    while(cin >> left >> right){
        if(left > right){
            temp = left;
            left = right;
            right = temp;
        }
        int odd = 0, even = 0;
        for(int i = left; i <= right; ++i){
            if(i % 2 == 0){
                even += i * i;
            }else{
                odd += i * i * i;
            }
        }
        cout << even << " " << odd << endl;
    }
    return 0;
}
