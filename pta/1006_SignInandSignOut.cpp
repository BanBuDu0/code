#include<iostream>
#include<string>
#include<vector>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

int early(vector<vector<string> > record, int M){
    int earliest = 24 * 60 * 60;
    int index = -1;
	for(int i = 0; i < M; i ++){
        int h = atoi(record[i][1].substr(0, 2).c_str()) * 60 * 60;
        int f = atoi(record[i][1].substr(3, 2).c_str()) * 60;
        int s = atoi(record[i][1].substr(6, 2).c_str());
        int total = h + f + s;
	    if(total < earliest){
	        earliest = total;
	        index = i;
	    }
	}
	return index;
}
int late(vector<vector<string> > record, int M){
    int earliest  = 0;
    int index = -1;
	for(int i = 0; i < M; i ++){
        int h = atoi(record[i][2].substr(0, 2).c_str()) * 60 * 60;
        int f = atoi(record[i][2].substr(3, 2).c_str()) * 60;
        int s = atoi(record[i][2].substr(6, 2).c_str());
        int total = h + f + s;
	    if(total > earliest){
	        earliest = total;
	        index = i;
	    }
	}
	return index;
}

int main(){
	int M;
	cin >> M;
	vector<vector<string> > record(M, vector<string>(3));
	for(int i = 0; i < M; i ++){
		cin >> record[i][0] >> record[i][1] >> record[i][2];
	}
	int index1 = early(record, M);
	int index2 = late(record, M);
	cout << record[index1][0] << " "<< record[index2][0];
	return 0;
}
