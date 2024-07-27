class Solution {
public:
    void floydWarshal(vector<vector<long long>>& dp){
        vector<vector<long long>> prev;

        for(int k=0; k<26; k++){
            prev = dp;
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    dp[i][j] = min(prev[i][j], prev[i][k] + prev[k][j]);
                }
            }
        }    

    }
    long long minimumCost(string source, string target, vector<char>& original, vector<char>& changed, vector<int>& cost) {
        int sz = source.size(), sz2 = changed.size();
        long long acost = 0;
        vector<vector<long long>> dp(26, vector<long long>(26, INT_MAX));
        for(int i=0; i<sz2; i++){
            dp[original[i] - 'a'][changed[i] - 'a'] = min(dp[original[i] - 'a'][changed[i] - 'a'], 1LL*cost[i]);
        }
        floydWarshal(dp);

        // for(int i=0; i<26; i++){
        //     for(int j=0; j<26; j++){
        //         cout << char(i+'a') << "->" << char(j+'a') << " = " << dp[i][j] << endl;
        //     }
        // }

        for(int i=0; i<sz; i++){
            if(source[i] != target[i]){
                int s = source[i]-'a', t = target[i]-'a';
                if(dp[s][t] == INT_MAX) return -1;
                acost += dp[s][t];
            }
        }

        return acost;
    }
};