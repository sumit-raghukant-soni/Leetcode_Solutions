class Solution {
    public int monotoneIncreasingDigits(int n) {
        int sz = findSize(n), tmp = n;
        int dp[] = new int[sz];

        for(int i=0; i<sz; i++){
            dp[(sz-1) - i] = tmp%10;
            tmp/=10;
        }

        int changes = 1;
        while(changes > 0){
            changes = 0;
            for(int i=sz-1; i>=0; i--){
                if(i-1 >= 0 && dp[i-1] > 0 && dp[i-1] > dp[i]){
                    dp[i-1]--;
                    for(int k=i; k<sz; k++) dp[k] = 9;
                    changes++;
                    break;
                }
            }

            // for(int i=0; i<sz; i++){
            //     System.out.print(dp[i]);
            // }
            // System.out.println();
        }

        int ans = 0;
        for(int i=0; i<sz; i++){
            ans = (ans*10) + dp[i];
        }

        return ans;
    }

    private int findSize(int n){
        int sz = 0;
        while(n > 0){
            n /= 10;
            sz++;
        }
        return sz;
    }
}