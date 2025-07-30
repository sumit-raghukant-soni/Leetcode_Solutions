class Solution {
    public int longestSubarray(int[] nums) {
        int sz = nums.length, cnt = 0, maxi = -1, ans = 0;

        for(int i : nums) maxi = maxi > i ? maxi : i;

        for(int i=0; i<sz; i++){
            cnt = 0;
            while(i < sz && nums[i] == maxi){
                cnt++;
                i++;
            }
            ans = ans > cnt ? ans : cnt;
        }

        return ans;
    }
}