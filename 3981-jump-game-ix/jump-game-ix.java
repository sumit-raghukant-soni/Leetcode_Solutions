class Solution {
    public int[] maxValue(int[] nums) {
        int sz = nums.length;
        int pre[] = new int[sz];
        int suf[] = new int[sz];
        int ans[] = new int[sz];

        pre[0] = nums[0];
        for(int i=1; i<sz; i++){
            pre[i] = pre[i-1] > nums[i] ? pre[i-1] : nums[i];
        }

        suf[sz-1] = nums[sz-1];
        for(int i=sz-2; i>=0; i--){
            suf[i] = suf[i+1] < nums[i] ? suf[i+1] : nums[i];
        }

        ans[sz-1] = pre[sz-1];

        for(int i=sz-2; i>=0; i--){
            if(pre[i] > suf[i+1]){
                ans[i] = ans[i+1];
            }
            else {
                ans[i] = pre[i];
            }
        }

        return ans;
    }
}