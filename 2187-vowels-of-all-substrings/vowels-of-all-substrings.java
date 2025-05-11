class Solution {
    public long countVowels(String word) {
        int sz = word.length(), last = -1;
        long ans = 0;
        long dp[] = new long[sz+1];

        for(int i=sz-1; i>=0; i--){
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                if(last == -1){
                    dp[i] = (sz-i) + dp[i+1];
                }
                else{
                    dp[i] = (last-i) + dp[i+1];
                }
            }
            else{
                dp[i] = dp[i+1];
            }
        }

        for(int i=0; i<sz; i++){
            ans += dp[i];
            // System.out.print(dp[i] + ",");
        }
        // System.out.println();

        return ans;
    }
}