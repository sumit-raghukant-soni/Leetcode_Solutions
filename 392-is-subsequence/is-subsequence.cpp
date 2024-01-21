class Solution {
public:
    bool isSubsequence(string s, string t) {
        int ind = 0, sz = t.length(), sz2 = s.length();

        for(int i=0; i<sz; i++){
            if(ind >= sz2) break;
            else if(s[ind] == t[i]) ind++;
        }

        return ind == sz2;
    }
};