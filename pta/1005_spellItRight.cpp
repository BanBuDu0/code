#include<iostream>
#include<string>
#include<string.h>
using namespace std;

/*
12345
one five
*/
string change(int a) {
	switch (a) {
	case 0:return "zero";
	case 1:return "one";
	case 2:return "two";
	case 3:return "three";
	case 4:return "four";
	case 5:return "five";
	case 6:return "six";
	case 7:return "seven";
	case 8:return "eight";
	case 9:return "nine";
	default: return "zero";
	}
}
int main() {
	char N[101];
	cin >> N;
	int length;
	int sum = 0;
	string out = "";
	length = strlen(N);
	for (int i = 0; i < length; i++) {
		sum += N[i] - '0';
	}

	out = change(sum % 10);
	sum /= 10;
	while (sum>0)
	{
		out = " " + out;
		out = change(sum % 10) + out;
		sum /= 10;
	}
	cout << out << endl;
	return 0;

}
