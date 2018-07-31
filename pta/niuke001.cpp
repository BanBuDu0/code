#include<iostream>
#include<vector>
#include<string>
#include<stdlib.h>
using namespace std;
/* 牛客001
5
2 / 5 4 / 15 1 / 30 - 2 / 60 8 / 3

3 1 / 3
*/
struct num {
	long int nu;
	long int de;
	long int inum;
};

int gcd(int b1, int b2)
{
	return b2 == 0 ? b1 : gcd(b2, b1%b2);
}
int main()
{
	int N;
	cin >> N;
	num* tnum = new num[N];
	char temp;
	for (int i = 0; i < N; i++) {
		tnum[i].inum = 0;
		cin >> tnum[i].nu;
		cin >> temp;
		cin >> tnum[i].de;
		if (tnum[i].nu >= tnum[i].de) {
			tnum[i].inum = tnum[i].nu / tnum[i].de;
			tnum[i].nu = tnum[i].nu % tnum[i].de;
		}
	}
	/*
	for (int i = 0; i < N; i++) {
	cout << tnum[i].inum << " " << tnum[i].nu << " " << tnum[i].de << endl;
	}*/
	num fin = tnum[0];
	//cout << fin.inum << " " << fin.nu << " " << fin.de << endl;
	for (int i = 1; i < N; i++) {
		fin.nu = fin.nu * tnum[i].de + tnum[i].nu * fin.de;
		fin.de = fin.de * tnum[i].de;
		fin.inum += tnum[i].inum;
	}
	if (fin.nu >= fin.de) {
		fin.inum += fin.nu / fin.de;
		fin.nu = fin.nu % fin.de;
	}

	int max = gcd(fin.de, fin.nu);
	max = abs(max);
	fin.nu /= max;
	fin.de /= max;

	if (fin.inum == 0) {
		if (fin.nu == 0) {
			cout << 0;
		}
		else {
			if (fin.de == 1) {
				cout << fin.nu;
			}
			else {
				cout << fin.nu << '/' << fin.de << endl;
			}

		}
	}
	else {
		if (fin.nu == 0) {
			cout << fin.inum;
		}
		else {
			if (fin.de == 1) {
				cout << fin.nu;
			}
			else {
				cout << fin.inum << " " << fin.nu << '/' << fin.de << endl;
			}
		}
	}
	return 0;
}
