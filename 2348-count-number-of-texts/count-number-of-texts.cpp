class Solution {
public:
    int countTexts(string pressedKeys) {
        char tmp;
        int sz = pressedKeys.size(), MOD = 1000000007;
        vector<long long int> dp(sz+1, 0);
        dp[0] = 1;
        for(int i=0; i<sz; i++){
            tmp = pressedKeys[i];
            int j = i;
            while(j < sz && tmp == pressedKeys[j]){
                for(int k=0; k<3; k++){
                    if(j-k >= i) dp[j+1] = ((dp[j+1]%MOD) + ((j-k >= 0) ? dp[j-k]%MOD : 1))%MOD;
                }
                if(tmp == '7' || tmp == '9')
                    if(j-3 >= i) dp[j+1] = (dp[j+1]%MOD + (j-3 >= 0 ? dp[j-3]%MOD : 1)) % MOD;
                j++;
            }
            if(i != j) i = j-1;
        }

        // for(auto i : dp) cout << i << " ";
        return dp[sz] % MOD;
    }
};