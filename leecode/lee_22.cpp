class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string t = "";
        generateParenthesisDFS(n, n, t, res);
        return res;
    }

    void generateParenthesisDFS(int left, int right, string t, vector<string> tr){
        if(left > right) return;
        if(left == 0 && right ==0){
            tr.push_back(t);
        }else{
            if(left > 0){
                generateParenthesisDFS(left - 1, right, t + '(', tr);
            }
            if(right > 0){
                generateParenthesisDFS(left, right - 1, t + ')', tr);
            }
        }

    }
};