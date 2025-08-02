class Solution {
    public int findSubstringInWraproundString(String s) {
        int sz = s.length(), ans = 0, prev, curr;
        int dp[] = new int[26];

        int maxi = 1;

        prev = s.charAt(0) - 'a';
        dp[prev] = 1;
        for(int i=1; i<sz; i++){
            curr = s.charAt(i) - 'a';
            if(prev - curr == 25 || curr - prev == 1){
                maxi++;
            }
            else maxi = 1;
            prev = curr;
            dp[curr] = dp[curr] > maxi ? dp[curr] : maxi;
        }

        for(int i=0; i<26; i++){
            ans += dp[i];
        }

        return ans;
    }
}