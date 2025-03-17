class Solution {
    public boolean divideArray(int[] nums) {
        int sz = nums.length;
        int[] d = new int[501];

        for(int i=0; i<sz; i++){
            d[nums[i]]++;
        }

        for(int i=0; i<=500; i++){
            if((d[i]&1) == 1) return false;
        }

        return true;
    }
}