class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == -2147483648){
            return 2147483647;
        }
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            return -dividend;
        }
        int res = 0;
        bool flag;
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0){
            flag = false;
        }else{
            flag = true;
        }
        long long Tdividend = abs((long long)dividend);
        long long Tdivisor = abs((long long)divisor);
        if(Tdividend < Tdivisor){
            return 0;
        }
        while(Tdividend >= Tdivisor){
            Tdividend -= Tdivisor;
            res += 1;
        }
        if(flag){
            return -res;
        }else{
            return res;
        }
    }
};