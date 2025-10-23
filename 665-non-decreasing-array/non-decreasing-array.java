class Solution {
    public boolean checkPossibility(int[] nums) {
        int sz = nums.length, flg = 0;

        for(int i=1; i<sz; i++){
            if(nums[i] < nums[i-1]){
                if(flg++ == 1 || (i > 1 && i < sz-1 && nums[i-2] > nums[i] && nums[i+1] < nums[i-1])) return false;
            }
        }

        return true;
    }
}