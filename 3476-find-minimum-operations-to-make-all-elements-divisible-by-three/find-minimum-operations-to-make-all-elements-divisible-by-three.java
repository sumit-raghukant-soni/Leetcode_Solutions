class Solution {
    public int minimumOperations(int[] nums) {
        int sz = nums.length, cnt = 0;

        for(int i=0; i<sz; i++){
            int mod = nums[i]%3;
            if(mod <= 1) cnt += mod;
            else cnt++;
        }

        return cnt;
    }
}