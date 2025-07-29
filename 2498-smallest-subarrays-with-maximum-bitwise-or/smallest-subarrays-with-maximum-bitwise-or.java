class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int sz = nums.length;
        int dp[][] = new int[32][sz], ans[] = new int[sz];

        for(int i=0; i<32; i++){
            int cmp = 1 << i, k = 0;
            for(int j=0; j<sz; j++){
                if((nums[j]&cmp) == cmp){
                    while(k <= j){
                        dp[i][k] = j - k + 1;
                        k++;
                    }
                }
            }
        }

        for(int i=0; i<sz; i++){
            int mini = 1;
            for(int j=0; j<32; j++){
                mini = mini > dp[j][i] ? mini : dp[j][i];
            }
            ans[i] = mini;
        }

        return ans;
    }
}