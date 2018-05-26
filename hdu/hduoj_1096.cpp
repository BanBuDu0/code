#include<iostream>
#include<vector>
using namespace std;

int main()
{
	int N, M, num;
	cin >> N;
	vector<int> sum(N);
	for (int i = 0; i < N; i++) {
		cin >> M;
		for (int j = 0; j < M; j++) {
			cin >> num;
			sum[i] += num;
		}
	}
	cout << sum[0] <<endl;
	for (int i = 1; i < N; i++) {
		cout << endl;
		cout << sum[i] << endl;
	}
	return 0;
}
