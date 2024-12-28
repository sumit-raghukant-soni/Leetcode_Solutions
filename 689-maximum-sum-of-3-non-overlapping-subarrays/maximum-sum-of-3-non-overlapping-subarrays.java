class Solution {
    private int[] ans = new int[3];
    private int ind = 0;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sz = nums.length, sz2 = sz-k+1, tmp = 0;
        int[] sums = new int[sz2];

        for(int i=0; i<sz; i++){
            tmp += nums[i];
            if(i >= k-1){
                sums[i-(k-1)] = tmp;
                tmp -= nums[i-(k-1)];
            }
        }

        List<Integer> indexes = new ArrayList<>();
        int dp[][] = new int[sz2][4];
        for(int i=0; i<sz2; i++){
            for(int j=0; j<4; j++) dp[i][j] = -1;
        }

        int maxSum = findMaxSum(dp, sums, sz2, k, 3, 0);

        // find Max-Sum 3 indices
        findAns(dp, sums, sz2, k, 3, 0);

        return ans;
    }

    private int findMaxSum(int[][] dp, int[] sums, int sz, int k, int index, int i){
        if(i >= sz || index == 0) return i >= sz ? index > 0 ? Integer.MIN_VALUE : 0 : 0;
        if(dp[i][index] != -1) return dp[i][index];

        int take = sums[i] + findMaxSum(dp, sums, sz, k, index-1, i+k), notTake = findMaxSum(dp, sums, sz, k, index, i+1);

        return dp[i][index] = Math.max(take, notTake);
    }

    private void findAns(int[][] dp, int[] sums, int sz, int k, int index, int i){
        if(index == 0) return;
        if(i >= sz) return;

        int take = sums[i] + findMaxSum(dp, sums, sz, k, index-1, i+k), notTake = findMaxSum(dp, sums, sz, k, index, i+1);

        if(take >= notTake){
            if(ind < 3) ans[ind++] = i;
            findAns(dp, sums, sz, k, index-1, i+k);
        }
        else{
            findAns(dp, sums, sz, k, index, i+1);
        }
    }
}