class Solution {
public:
    unordered_map<int, int> dp;
    int numTrees(int n) {
        if(n <= 1) return 1;
        if(dp.find(n) != dp.end()) return dp[n];

        int ans = 0;
        for(int i=1; i<=n; i++){
            ans += numTrees(i-1) * numTrees(n-i);
        }
        return dp[n] = ans;
    }
};