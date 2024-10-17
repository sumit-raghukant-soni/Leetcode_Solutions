class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int l=0, r=0, sz = nums.length, ans = 0;

        for(int i=0; i<sz; i++){
            // System.out.println(l + " " + r);
            if(i-1 >= 0 && l != r && nums[i-1] >= nums[i]){
                // System.out.println();
                ans = Math.max(ans, r-l);
                l = r;
            }
            // System.out.println(nums[i] + " ");
            r++;
        }

        ans = Math.max(ans, r-l);

        return ans;
    }
}