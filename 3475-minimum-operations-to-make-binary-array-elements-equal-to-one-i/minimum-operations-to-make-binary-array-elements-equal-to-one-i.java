class Solution {
    public int minOperations(int[] nums) {
        int sz = nums.length, ans = 0, sum = 0, tmp = 0;

        for(int i=0; i<sz; i++) sum += nums[i];

        for(int i=0; i<sz-2; i++){
            if(nums[i] == 0){
                ans++;
                tmp = (nums[i]+nums[i+1]+nums[i+2]);
                if(tmp == 2) sum -= 1;
                else if(tmp == 1) sum += 1;
                else sum += 3;
                nums[i] = nums[i]^1;
                nums[i+1] = nums[i+1]^1;
                nums[i+2] = nums[i+2]^1;
            }
        }

        return sum == sz ? ans : -1;
    }
}