class Solution {
public:
    int scoreOfString(string s) {
        int sz = s.length(), ans = 0;

        for(int i=0; i<sz-1; i++){
            ans += abs(s[i] - s[i+1]);
        }

        return ans;
    }
};