class Solution {
public:
    int maxScore(string s) {
        int sz = s.length();
        int o=0, z=0, ans=0;

        for(int i=0; i<sz; i++)
            if(s[i] == '1') o++;

        for(int i=0; i<sz-1; i++){
            if(s[i] == '0') z++;
            else o--;
            ans = max(z + o, ans);
        }

        return ans;
    }
};