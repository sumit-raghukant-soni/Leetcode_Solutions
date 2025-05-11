class Solution {
    public int triangularSum(int[] nums) {
        int sz = nums.length;

        for(int i=1; i<sz; i++){
            for(int j=0; j<sz-i; j++){
                nums[j] = (nums[j] + nums[j+1])%10;
            }
        }

        return nums[0];
    }
}