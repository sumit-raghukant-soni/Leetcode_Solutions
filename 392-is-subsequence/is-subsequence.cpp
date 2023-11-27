class Solution {
public:
    bool isSubsequence(string s, string t) {
        int j=0, sz = t.length(), sz2 = s.length();

        for(int i=0; i<sz; i++){
            if(j < sz){
                if(t[i] == s[j])
                    j++;
            }
            else return true;
        }

        if(j == sz2) return true;

        return false;
    }
};