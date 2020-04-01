#include<stdio.h>
#include<string.h>
int max(int i, int j){
    if(i > j){
        return i;
    }else{
        return j;
    }
}
int lengthOfLongestSubstring(char* s) {
    int count[256] = {[0 ... 255] = -1};
    int len = strlen(s);
    int left = 0, right = 0;
    int res = 0;
    if(len == 0){
        return 0;
    }else{
        for(right; right < len; right++){
            left = max(count[s[right]], left);
            res = max(res, right - left + 1);
            count[s[right]] = right + 1;

        }
    }
    return res;
}


int main(){
    char s[10] = {'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b'};
    int i = lengthOfLongestSubstring(s);
    printf("%d", i);
}