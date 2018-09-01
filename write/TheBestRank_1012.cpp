#include<iostream>
#include<string>
using namespace std;

// 1012
struct grades {
	char id[6];
	int c;
	int m;
	int e;
	int a;
};

struct outputMap {
	char id[6];
	string result;
};

int max(int temp[4]) {
	int re = 0;
	for (int i = 0; i < 4; i++) {
		if (temp[i] >= re) {
			re = temp[i];
		}
	}
	return re;
}

int main() {
	int n, m;
	cin >> n >> m;
	grades* grade = new grades[n];
	outputMap* outputmap = new outputMap[m];
	for (int i = 0; i < n; i++) {
		cin >> grade[i].id >> grade[i].c >> grade[i].m >> grade[i].e;
		grade[i].a = (grade[i].c + grade[i].m + grade[i].e) / 3;
	}
	for (int i = 0; i < m; i++) {
		cin >> outputmap[i].id;
		outputmap[i].result = "N/A";
	}
	/*
	for (int i = 0; i < n; i++) {
		cout << grade[i].id <<" "<< grade[i].c <<" "<< grade[i].m <<" "<< grade[i].e <<" "<< grade[i].a<<endl;
	}
	for (int i = 0; i < m; i++) {
		cout << outputmap[i].id << " " << outputmap[i].result<<endl;
	}*/
	int ic
	for (int i = 0; i < n; i++) {

	}
	int na = 0;

}