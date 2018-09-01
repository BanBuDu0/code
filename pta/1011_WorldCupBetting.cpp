/*
1.1 2.5 1.7
1.2 3.0 1.6
4.1 1.2 1.1
*/
/*
T T W 37.98
*/
#include<iostream>
#include<stdio.h>
using namespace std;

struct map {
	int index;
	double num;
};
int main() {
	double game[3][3];
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> game[i][j];
		}
	}
	map mymap[3];
	for (int i = 0; i < 3; i++) {
		double temp = 0;
		for (int j = 0; j < 3; j++) {	
			if (game[i][j] > temp) {
				temp = game[i][j];
				mymap[i].index = j;
				mymap[i].num = game[i][j];
			}
		}
	}
	for (int i = 0; i < 3; i++) {
		if (mymap[i].index == 0) {
			cout << "W ";
		}
		else if (mymap[i].index == 1) {
			cout << "T ";
		}
		else {
			cout << "L ";
		}
	}
	double tn = 1;
	for (int i = 0; i < 3; i++) {
		tn = tn * mymap[i].num;
	}
	tn = (tn * 0.65 - 1) * 2 + 0.001;//不加0.001牛客过不了
	printf("%.2lf", tn);
	return 0;
}