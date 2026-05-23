class Solution {
    public boolean check(int[] nums) {
        int sz = nums.length;
        int cnt = 0;

        for(int i=1; i<sz; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
            }
        }

        if(nums[0] < nums[sz-1]) cnt++;

        return cnt <= 1;
    }
}