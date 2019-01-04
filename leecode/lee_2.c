int inGroup(char* s, char c, int left, int right){
    int i = left;
    while(i < right){
        if(s[i] == c){
            return 1;
        }
        ++i;
    }
    return 0;

}
int lengthOfLongestSubstring(char* s) {
    int i = 0;
    int left = i;
    int len = strlen(s);
    if(len == 0){
        return 0;
    }else{
        int count = 1;
        int j, flag;
        while(i < len){
            int s_cont = 1;
            left = i;
            j = i + 1;
            while(j < len){
                flag = inGroup(s, s[j], left, j);
                if(flag == 0){
                    ++s_cont;
                }else{
                    break;
                }
                ++j;
            }
            if(s_cont > count){
                count = s_cont;
            }
            ++i;
        }
        return count;
        
    } 
}
