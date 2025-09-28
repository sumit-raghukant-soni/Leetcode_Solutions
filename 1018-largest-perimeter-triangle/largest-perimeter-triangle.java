class Solution {
    public int largestPerimeter(int[] nums) {
        int sz = nums.length, ans = 0;

        Arrays.sort(nums);

        for(int i=0; i<sz-2; i++){
            if(nums[i] + nums[i+1] > nums[i+2] && nums[i+1] + nums[i+2] > nums[i] && nums[i+2] + nums[i] > nums[i+1]){
                ans = ans > (nums[i] + nums[i+1] + nums[i+2]) ? ans : (nums[i] + nums[i+1] + nums[i+2]);
            }
        }

        return ans;
    }
}