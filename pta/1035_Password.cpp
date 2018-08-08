#include<iostream>
#include<vector>
#include<string.h>
#include<stdlib.h> //exit() needs this in g++
using namespace std;

typedef struct {
    char name[11];
    char passwd[11];
} account;

int main() {
    int n;
    cin >> n;
    vector<account> accounts;
    int ct = 0;
    for(int i = 0; i < n; i++) {
        int flag = 0;
        account temp;
        cin >> temp.name >> temp.passwd;
        int len = strlen(temp.passwd);
        for(int j = 0; j < len; j++) {
            switch(temp.passwd[j]) {
            case '1':
                temp.passwd[j] = '@';
                flag ++;
                break;
            case '0':
                temp.passwd[j] = '%';
                flag++;
                break;
            case 'l':
                temp.passwd[j] = 'L';
                flag ++;
                break;
            case 'O':
                temp.passwd[j] = 'o';
                flag ++;
                break;
            }
        }
        if(flag != 0) {
            accounts.push_back(temp);
            ct ++;
        }
    }
    if(ct == 0) {
        if(n == 1) {
            cout << "There is " << n << " account and no account is modified" << endl;
            exit(0);
        } else {
            cout << "There are " << n << " accounts and no account is modified" << endl;
            exit(0);
        }
    }
    cout << ct << endl;
    for(int i = 0; i < ct; i++) {
        cout << accounts[i].name << " " << accounts[i].passwd << endl;
    }

}
