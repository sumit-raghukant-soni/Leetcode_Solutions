class Solution {
public:
    int numDecodings(string s) {
        if(s[0] == '0') return 0;
        long long int cnt = 1, sz = s.length();

        vector<int> ans(sz);
        
        ans[0] = 1;
        for(int i=1; i<sz; i++){
            int sin = s[i] - '0';
            int dbl = ((s[i-1] - '0') * 10) + sin;
            if(sin != 0){
                if(i-1 >= 0) ans[i] += ans[i-1];
                else ans[i] = 1;
            }
            if(dbl >= 10 && dbl <= 26){
                if(i-2 >= 0) ans[i] += ans[i-2];
                else ans[i] += 1;
            }
            // cout << ans[i] << " ";
        }

        return ans[sz-1];
    }
};