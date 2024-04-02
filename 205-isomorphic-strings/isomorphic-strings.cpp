class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> mp1, mp2;
        int sz = s.length();

        for(int i=0; i<sz; i++){
            mp1[s[i]] = t[i];
            mp2[t[i]] = s[i];
        }

        for(int i=0; i<sz; i++){
            if(s[i] != mp2[t[i]] || t[i] != mp1[s[i]]) return false;
        }

        return true;
    }
};