#include<iostream>
#include<vector>
using namespace std;

int main() {
	int K;
	cin >> K;
	vector<int> nums;
	for (int i = 0; i < K; i++) {
		int a;
		cin >> a;
		nums.push_back(a);
	}
	int Maxsum = 0;
	int temp = 0;
	int begin, end;
	int tempbegin = 0;
	for (int i = 0; i < nums.size();i++) {
		temp += nums[i];
		if (temp < 0) {
			temp = 0;
			tempbegin = i+1;
		}
		else {
			if (temp > Maxsum)
			{
				begin = nums[tempbegin];
				Maxsum = temp;
				end = nums[i];
			}
		}
	}
	cout << Maxsum <<" "<<begin << " "<< end << endl;
	nums.clear();
	
	return 0;
}