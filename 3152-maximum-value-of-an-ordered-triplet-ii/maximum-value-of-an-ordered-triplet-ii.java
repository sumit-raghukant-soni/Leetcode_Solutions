class Solution {
    public long maximumTripletValue(int[] nums) {
        int sz = nums.length;
        int pre[] = new int[sz], next[] = new int[sz];
        long ans = 0;

        pre[0] = -1;
        for(int i=1; i<sz; i++){
            pre[i] = Math.max(pre[i-1], nums[i-1]);
        }

        next[sz-1] = -1;
        for(int i=sz-2; i>=0; i--){
            next[i] = Math.max(next[i+1], nums[i+1]);
        }

        for(int i=1; i<sz-1; i++){
            ans = Math.max(ans, 1L * (pre[i] - nums[i]) * next[i]);
        }

        return ans;
    }
}