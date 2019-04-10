#include<iostream>
#include<string>
#include<stdio.h>
using namespace std;

int main(int argc, char const *argv[]) {
    int n;
    while(cin >> n) {
        getchar();
        for(int i = 0; i < n; ++i) {
            string t;
            getline(cin, t);
            int sum = 0;
            if(t[0] >= '0' && t[0] <= '9') {
                cout << "no" << endl;
            }else{
            for(int j = 0; j < t.size(); ++j) {
                if((t[i] >= '0' && t[i] <= '9')||(t[i] >= 'a' &&
                                                  t[i] <= 'z')||(t[i] >= 'A' && t[i] <= 'Z')||t[i] == '_') {
                    sum++;
                }

            }
            if(sum == t.size())
                printf("yes\n");
            else
                printf("no\n");
        }
        }
    }
    return 0;
}
