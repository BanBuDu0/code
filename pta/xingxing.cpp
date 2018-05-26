#include<iostream>
#include<math.h>
using namespace std;

int main() {
	int a;
	int blank = 0;
	char b;
	cin >> a >> b;
	int n = sqrt((a + 1) / 2);
	int left = a - (2 * n*n - 1);
	for (int i = n; i > 0; i--) {
		for (int z = 0; z < blank; z++) {
			cout << " ";
		}
		for (int j = 2 * i - 1; j > 0; j--) {
			cout << b;
		}
		blank++;
		cout << endl;
	}
	blank--;
	for (int i = 1; i < n; i++) {
		blank--;
		for (int z = 0; z < blank; z++) {
			cout << " ";
		}
		for (int j = 2 * i + 1; j > 0; j--) {
			cout << b;
		}	
		cout << endl;
	}
	cout << left <<endl;
	return 0;
}
