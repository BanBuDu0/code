#include<iostream>
#include<vector>
using namespace std;

// -1
int main() {
	int K = 0;
	cin >> K;
	vector<int> nums;
	for (int i = 0; i < K; i++) {
		int a;
		cin >> a;
		nums.push_back(a);
	}
	int Maxsum = 0;
	int temp = 0;
	int ibegin = 0;
	int iend = 0;
	int tempbegin = 0;
	for (int i = 0; i < K;i++) {
		temp += nums[i];
		if (temp < 0) {
			temp = 0;
			tempbegin = i+1;
		}
		else {
			if (temp > Maxsum)
			{
				ibegin = nums[tempbegin];
				Maxsum = temp;
				iend = nums[i];
			}
		}
	}
	cout << Maxsum <<" "<<ibegin << " "<< iend << endl;
	nums.clear();
	return 0;
}
