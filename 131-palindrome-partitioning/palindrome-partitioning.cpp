class Solution {
public:
    void solve(string& s, int& sz, vector<vector<string>>& final,
               vector<string> ans, string str, string rev, int ind) {
        if (ind == sz) {
            if (str != "" && str == rev)
                ans.push_back(str);
            final.push_back(ans);
        }

        for (; ind < sz; ind++) {
            str += s[ind];
            rev = s[ind] + rev;
            if (str == rev) {
                ans.push_back(str);
                solve(s, sz, final, ans, "", "", ind + 1);
                ans.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        int sz = s.length();

        solve(s, sz, ans, {}, "", "", 0);

        return ans;
    }
};