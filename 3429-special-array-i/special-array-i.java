class Solution {
    public boolean isArraySpecial(int[] nums) {
        int sz = nums.length;

        for(int i=1; i<sz; i++){
            if((nums[i]&1) == (nums[i-1]&1)){
                return false;
            }
        }

        return true;
    }
}