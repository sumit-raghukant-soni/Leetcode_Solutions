class Solution {
    public boolean isArraySpecial(int[] nums) {
        int sz = nums.length;
        boolean flg = (nums[0]&1) == 0 ? false : true;

        for(int i=1; i<sz; i++){
            if(((nums[i]&1) == 1) != flg){
                flg = !flg;
            }
            else return false;
        }

        return true;
    }
}