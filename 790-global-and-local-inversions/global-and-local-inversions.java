class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int sz = nums.length;

        for(int i=0; i<sz; i++){
            if(Math.abs(nums[i] - i) > 1) return false;
        }

        return true;
    }
}