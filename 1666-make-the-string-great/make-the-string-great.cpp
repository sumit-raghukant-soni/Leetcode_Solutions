class Solution {
public:
    string makeGood(string s) {
        int sz = s.length();
        string ans = "";

        for(int i=0; i<sz; i++){
            if(!ans.empty() == 0 || ans.back() != char(s[i]^32)){
                ans += s[i];
            }
            else ans.pop_back();
        }

        return ans;
    }
};