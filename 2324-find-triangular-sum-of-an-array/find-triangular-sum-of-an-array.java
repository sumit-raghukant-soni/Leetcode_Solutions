class Solution {
    public int triangularSum(int[] nums) {
        int sz = nums.length;
        int newNums[] = new int[sz];

        for(int i=1; i<sz; i++){
            for(int j=0; j<sz-i; j++){
                newNums[j] = (nums[j] + nums[j+1])%10;
            }
            for(int j=0; j<sz-i; j++){
                nums[j] = newNums[j];
            }
        }

        return nums[0];
    }
}