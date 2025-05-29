class Solution {
    public int longestWPI(int[] hours) {
        int sz = hours.length, ans = 0;
        int dp[] = new int[sz];

        for(int i=0; i<sz; i++){
            if(hours[i] > 8) dp[i]++;
            else dp[i]--;
            if(i-1 >= 0) dp[i] += dp[i-1];    
            // System.out.print(dp[i] + ", ");
        }

        for(int i=0; i<sz; i++){
            if(dp[i] > 0){
                ans = i+1;
                continue;
            }
            for(int j=0; j<i; j++){
                if(dp[j]+1 == dp[i]){
                    ans = Math.max(ans, i - j);
                    break;
                }
            }
        }

        return ans;
    }
}