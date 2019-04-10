class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.size() == 0){
            return 0;
        }
        if(needle.size() > haystack.size()){
            return -1;
        }
        int i = 0, j = 0;
        while(i < haystack.size()){
            while(j < needle.size() && haystack[i] == needle[j]){
                ++j;
                ++i;
            }
            if(j == needle.size() - 1){
                return j - needle.size() + 1;
            }
            ++i;
        }
        return -1;
    }
};