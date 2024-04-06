class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int sz = s.length();
        string ans = "";
        int open = 0, close = 0;

        for (int i = 0; i < sz; i++) {
            if (s[i] == '(')
                open++;
            if (s[i] == ')')
                close++;
        }

        open = 0;
        for (int i = 0; i < sz; i++) {
            if (s[i] == '(') {
                if (close > open)
                    ans += s[i];
                open++;
            } else if (s[i] == ')') {
                if (open > 0) {
                    ans += s[i];
                    open--;
                }
                close--;
            } else
                ans += s[i];
        }

        return ans;
    }
};