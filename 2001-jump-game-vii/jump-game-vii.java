class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int sz = s.length();
        if(s.charAt(sz-1) == '1') return false;
        int dp[] = new int[sz], maxR = maxJump, reach = 0;

        dp[0] = 1;
        for(int i=minJump; i<sz; i++){
            if(i > maxR) return false;

            reach += dp[i - minJump];
            if(i > maxJump) reach -= dp[i - maxJump - 1];

            if(reach > 0 && s.charAt(i) == '0') {
                dp[i] = 1;
                maxR = i + maxJump;
            }
        }

        return reach > 0;
    }
}