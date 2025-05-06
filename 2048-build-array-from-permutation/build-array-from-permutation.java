class Solution {
    public int[] buildArray(int[] nums) {
        int sz = nums.length;
        int ans[] = new int[sz];

        for(int i=0; i<sz; i++){
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}