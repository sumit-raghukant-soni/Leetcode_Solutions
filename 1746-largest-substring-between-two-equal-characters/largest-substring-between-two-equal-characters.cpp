class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        int ans = -1;
        int sz = s.length();
        int alpha[26];

        for(int i=0; i<26; i++) alpha[i] = -1;

        for(int i=0; i<sz; i++){
            if(alpha[s[i] - 'a'] == -1) alpha[s[i] - 'a'] = i;
            else
                ans = max(ans, i - alpha[s[i] - 'a'] - 1);
        }

        return ans;
    }
};