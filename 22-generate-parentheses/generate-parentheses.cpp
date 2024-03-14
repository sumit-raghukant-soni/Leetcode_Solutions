class Solution {
public:
    void solve(int& n, vector<string>& ans, string str, int open, int close){
        if(n*2 == open + close){
            ans.push_back(str);
            return;
        }

        if(open < n) solve(n, ans, str + "(", open+1, close);
        if(close < open) solve(n, ans, str + ")", open, close+1);
    }
    vector<string> generateParenthesis(int n) {
        vector<string> ans;

        solve(n, ans, "", 0, 0);

        return ans;
    }
};