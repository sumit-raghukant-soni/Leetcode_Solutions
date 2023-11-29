class Solution {
public:
    string removeStars(string s) {
        if(s.find('*') == string::npos) return s;
        string ans = "";
        int sz = s.length(), cnt = 0;

        for(int i=0; i<sz; i++){
            if(s[i] == '*') ans.pop_back();
            else ans += s[i];
        }

        return ans;
    }
};