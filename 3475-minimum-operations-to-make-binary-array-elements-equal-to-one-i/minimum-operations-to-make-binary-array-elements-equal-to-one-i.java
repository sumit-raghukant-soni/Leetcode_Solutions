class Solution {
    public int minOperations(int[] nums) {
        int sz = nums.length, ans = 0, sum = 0;

        for(int i=0; i<sz; i++) sum += nums[i];

        for(int i=0; i<sz-2; i++){
            if(nums[i] == 0){
                ans++;
                sum -= (nums[i]+nums[i+1]+nums[i+2]);
                nums[i] = nums[i]^1;
                nums[i+1] = nums[i+1]^1;
                nums[i+2] = nums[i+2]^1;
                sum += (nums[i]+nums[i+1]+nums[i+2]);
            }
        }

        // for(int i=0; i<sz; i++){
        //     System.out.print(nums[i] + ",");
        // }

        return sum == sz ? ans : -1;
    }
}