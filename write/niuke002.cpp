#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;
char num[10][5] = { "ling","yi","er","san","si","wu","liu","qi","ba","jiu" };
char wei[5][5] = { "Shi","Bai","Qian","Wan","Yi" };
int main() {
	char s[15];
	gets(s);
	int len = strlen(s);
	int left = 0, right = len - 1;
	if (s[0] == '-') {
		cout << "Fu";
		left++;
	}
	while (left + 4 <= right) {
		right -= 4;
	}

	while (left<len) {
		bool flag = false;
		bool isprint = false;
		while (left <= right) {
			if (left>0 && s[left] == '0')
				flag = true;
			else {
				if (flag) {
					cout << " ling";
					flag = false;
				}
				if (left>0)
					cout << " ";
				cout << num[s[left] - '0'];
				isprint = true;
				if (left != right)
					cout << " " << wei[right - left - 1];
			}
			left++;
		}
		if (isprint == false && right != len - 1 && s[right + 1] != '0') {
			cout << " ling";
		}
		if (isprint == true && right != len - 1)
			cout << " " << wei[(len - 1 - right) / 4 + 2];
		right += 4;
	}

	return 0;
}
