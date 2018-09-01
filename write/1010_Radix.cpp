#include<iostream>
#include<string>
using namespace std;

//1010 radix

int cToInt(char c) {
	if (c >= '0' && c <= '9') {
		return c - '0';
	}
	else {
		return c - 'a' + 10;
	}
}

int main() {
	char n1[11], n2[11];
	int  tag, radix;
	cin >> n1 >> n2 >> tag >> radix;
	int v = 0;
	for (int i = 0; n1[i] != '\0'; i++) {
		v = cToInt(n1[i]) + v * radix;
	}
	cout << v;


}