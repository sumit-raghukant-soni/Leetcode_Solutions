class Solution {
public:
    bool isCircularSentence(string s) {
        int sz = s.length();

        if(s[0] != s[sz-1]) return false;

        for(int i=0; i<sz; i++)
            if(s[i] == ' ' && s[i-1] != s[i+1]) return false;

        return true;
    }
};