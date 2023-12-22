class Solution {
public:
    int maxScore(string s) {
        int ones = 0, zero = 0, ans = 0, sz = s.length();

        for(auto i : s)
            if(i == '1') ones++;

        for(int i=0; i<sz-1; i++){
            if(s[i] == '1') ones--;
            else zero++;
            ans = max(zero + ones, ans);
        }

        return ans;
    }
};