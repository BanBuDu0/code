#include<iostream>
#include<vector>
using namespace std;

/*
input
10
-10 1 2 3 4 -5 -23 3 7 -21
*/
/*
output
10 1 4
*/
// -1
int main() {
	int K = 0;
	/* If all the K numbers are negative, then its maximum sum is defined 
	to be 0, and you are supposed to output the first and the last numbers
	 of the whole sequence.
	*/
	//use the flag to sign if all the K numbers are negative.
	int flag = 0;
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
		if(nums[i] >= 0){
			flag = 1;
		}
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
	if(flag == 0){
		cout << 0 << " "<<nums[0] << " "<< nums[K - 1] <<endl;
	}else{
		cout << Maxsum <<" "<<ibegin << " "<< iend << endl;
	}
	nums.clear();
	return 0;
}
