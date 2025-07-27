class Solution {
    public int countHillValley(int[] nums) {
        int sz = nums.length, prev = nums[0], i = 0, curr, ans = 0;

        while(i<sz && nums[i] == prev) i++;
        for(;i<sz;){
            curr = nums[i];
            while(i < sz && nums[i] == curr) i++;
            if((i < sz) && ( (prev < curr && curr > nums[i]) || (prev > curr && curr < nums[i]) ) ) ans++;
            prev = curr;
        }

        return ans;
    }
}