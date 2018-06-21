#include<iostream>
using namespace std;
//1027
void op(int c) {
	if (c == 10) {
		cout << 'A';
	}
	else if (c == 11) {
		cout << 'B';
	}
	else if (c == 12) {
		cout << 'C';
	}
	else {
		cout << c;
	}
}

int main() {
	int color[3];
	cin >> color[0] >> color[1] >> color[2];
	cout << '#';
	for (int i = 0; i < 3; i++) {
		if (color[i] >= 13) {
			while (color[i] >= 13) {
				int c = color[i] / 13;
				int v = color[i] % 13;
				op(c); 
				op(v);
				color[i] = v;
			}
		}
		else {
			cout << '0' ;
			op(color[i]);
		}
	}

}