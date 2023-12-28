class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
        int m = text1.length(), n = text2.length();
        vector<int> prev(n+1, 0), curr(n+1, 0);

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1[i-1] == text2[j-1]){
                    curr[j] = 1 + prev[j-1];
                }
                else curr[j] = max(curr[j-1], prev[j]);
            }
            prev = curr;
        }

        return prev[n];
    }
};