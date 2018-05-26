#include<iostream>
using namespace std;

int mian() {
	int N;
	int time = 0;
	cin >> N;
	int* allAction = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> allAction[i];
	}
	int time1 = allAction[0] * 6 + 5;
	if (N == 1) {
		cout << time1;
	}
	else {
		for (int i = 1; i < N; i++) {
			if (allAction[i] > allAction[i - 1]) {
				time += (allAction[i] - allAction[i - 1]) * 6;
			}
			else
			{
				time += (allAction[i - 1] - allAction[i]) * 4;
			}
			time += 5;
		}
	}
	time += time1;
	cout << time;
	return 0;

}