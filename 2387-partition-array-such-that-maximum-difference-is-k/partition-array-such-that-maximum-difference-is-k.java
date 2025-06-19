class Solution {
    public int partitionArray(int[] nums, int k) {
        int sz = nums.length, last = 0, ans = 1;
        Arrays.sort(nums);

        for(int i=0; i<sz; i++){
            if(nums[i]- nums[last] > k){
                last = i;
                ans++;
            }
        }

        return ans;
    }
}