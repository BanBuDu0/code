#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>
#include<stdio.h>
using namespace std;

/*
  这里因为n1 和 n2是形式上相反的数，例如： 67， 76
  使用加法法则， 
（1）
    67
  + 76
   ①①
  =143

 反过来看是一样的
（2）
    67
    76
  +  ①①  
    341
再把string 颠倒，就是所求结果。
   因为（1）中加法是先 6+7，进位为1,；（2）中加法同样是6+7,进位为1.只不过所得结果反着写。
*/
void add(string &n1, string n2) {
    int flag = 0;
    for(int i = 0; i < n2.length(); i++){
        n1[i] = n1[i] + n2[i] + flag - '0';
        flag = 0;
        if(n1[i] > '9'){
            n1[i] -= 10;
            flag = 1;
        }

    }
    if(flag == 1){
        n1 += '1';
    }
    reverse(n1.begin(), n1.end());
}
int main() {
    string n1, n2;
    int k, i;
    cin >> n1 >> k;
    for(i = 0; i <= k; i++) {
        n2 = n1;
        reverse(n1.begin(), n1.end());
        if(n2 == n1 || i == k){
            break;
        }
        add(n1, n2);
    }
    reverse(n1.begin(), n1.end());
    cout << n1 << endl;
    cout << i;
    return 0;
}
