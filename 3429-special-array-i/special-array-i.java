class Solution {
    public boolean isArraySpecial(int[] nums) {
        int sz = nums.length, tmp = 0;

        for(int i=1; i<sz; i++){
            tmp += ((nums[i]^nums[i-1])&1);        
        }

        return tmp == sz-1;
    }
}