#include<iostream>
#include<vector>
using namespace std;

//牛客pass  pat超内存
int main() {
	int N1, N2;
	cin >> N1;
	vector<long> s1, s2;
	int m;
	for (int i = 0; i < N1; i++) {
		cin >> m;
		s1.push_back(m);
	}
	cin >> N2;
	for (int i = 0; i < N2; i++) {
		cin >> m;
		s2.push_back(m);
	}
	int i = 0, j = 0, index = 0, k = (N1 + N2 - 1) / 2;
	while (i < N1 && j < N2) {
		if (s1[i] <= s2[j]) {
			if (index == k) {
				printf("%ld\n", s1[i]);
				break;
			}
			index++;
			i++;
		}
		else if (s1[i] > s2[j]) {
			if (index == k) {
				printf("%ld\n", s2[j]);
				break;
			}
			index++;
			j++;
		}
	}
	if (i == N1)
		printf("%ld\n", s2[k + j - index]);
	else if (j == N2)
		printf("%ld\n", s1[k + i - index]);

}