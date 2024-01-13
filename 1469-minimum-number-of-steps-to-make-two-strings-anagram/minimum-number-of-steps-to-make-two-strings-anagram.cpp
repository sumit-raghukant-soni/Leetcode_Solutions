class Solution {
public:
    int minSteps(string s, string t) {
        int alpha1[26] = {0}, alpha2[26] = {0};
        int sz = s.length(), cnt = 0;

        for(int i=0; i<sz; i++){
            alpha1[s[i] - 'a']++;
            alpha2[t[i] - 'a']++;
        }

        for(int i=0; i<26; i++){
            cnt += abs(alpha1[i] - alpha2[i]);
        }

        return cnt ? cnt/2 : 0;
    }
};