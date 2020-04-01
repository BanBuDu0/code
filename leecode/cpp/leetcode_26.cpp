class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len = nums.size();
        if(len == 0){
            return 0;
        }
        int f = 0, l = 0;
        while(f < len){
            if(nums[f] == nums[l]){
                ++f;
            }else{
                nums[++l] = nums[f];
            }
        }
        return l + 1;
        
    }
};