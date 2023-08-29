class Solution {
public:
    string generateTheString(int n) {
        string ans = "";
        
        for(int i=0; i<n; i++)
            ans += 'a';

        if((n&1) == 0)
            ans[n-1]++;

        return ans;
    }
};