class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sz = nums.length, ans = sz+1, j=0, sum =0;

        for(int i=0; i<sz; i++){
            sum += nums[i];
            while(sum >= target && j <= i){
                ans = Math.min(ans, i-j+1);
                sum -= nums[j++];
            }
        }

        return ans == sz+1 ? 0 : ans;
    }
}