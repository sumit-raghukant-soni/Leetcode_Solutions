class Solution {
public:
    int firstUniqChar(string s) {
        int alpha[26] = {0};
        int sz = s.length();

        for(int i=0; i<sz; i++) alpha[s[i] - 'a']++;

        for(int i=0; i<sz; i++) if(alpha[s[i] - 'a'] == 1) return i;

        return -1;
    }
};