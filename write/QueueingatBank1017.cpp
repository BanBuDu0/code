#include<iostream>
#include<string.h>
#include<vector>
#include<stdlib.h>
#include<algorithm>
#include<queue>
using namespace std;

typedef struct{
	int h;
	int m;
	int s;
	int pt;
}Transaction;
bool comp(Transaction a, Transaction b){
    if(a.h != b.h){
        return a.h < b.h;
    }else if(a.m != b.m){
        return a.m < b.m;
    }else{
        return a.s < b.s;
    }
}
int main(int argc, char const *argv[])
{
	int n, k;
	queue<transactions> q;
	vector<Transaction> transactions;
	Transaction temp;
	string t;
	cin >> n >> k;
	for(int i = 0; i < n; ++i){
		cin >> t >> temp.pt;
		temp.h = atoi(t.substr(0, 2).c_str());
		temp.m = atoi(t.substr(3, 5).c_str());
		temp.s = atoi(t.substr(6, 8).c_str());
		transactions.push_back(temp);
	}
	sort(transactions.begin(), transactions.end(), comp);
/*	for(int i = 0;i <n;++i){
        cout << transactions[i].h << " " << transactions[i].m << " " << transactions[i].s << " " <<transactions[i].pt << endl;
	}
*/
    int time = 0;
    for(int i = 0; i < n; ++i){
    	if(transactions[i].h < 8){
    		time += (8 - transactions[i].h) * 60 * 60 + (60 - transactions[i].m) * 60 + (60 - transactions[i].s);
    		time += transactions[i].pt * 60;
    	}else{
    		int compTime = 0
    	}
    }

	return 0;
}
