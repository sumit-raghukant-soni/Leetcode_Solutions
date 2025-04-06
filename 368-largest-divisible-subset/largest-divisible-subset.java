class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int sz = nums.length, maxi = 1, num = -1;
        int dp[] = new int[sz];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();

        for(int i=1; i<sz; i++){
            for(int j=i-1; j>=0; j--){
                if((nums[i]%nums[j] == 0) && (dp[i] < (dp[j]+1))){
                    dp[i] = dp[j] + 1;
                    if(maxi < dp[i]) maxi = dp[i];
                }
            }
        }

        for(int i=sz-1; i>=0; i--){
            if(dp[i] == maxi && (num == -1 || (num%nums[i] == 0))){
                arr.add(nums[i]);
                num = nums[i];
                maxi--;
            }
        }

        return arr;
    }
}