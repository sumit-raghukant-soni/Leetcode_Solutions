class Solution {
    int freq[] = new int[1001];
    public int beautifulSubsets(int[] nums, int k) {
        int sz = nums.length;
        Arrays.sort(nums);
        
        return solve(nums, sz, k, 0) - 1;
    }

    private int solve(int nums[], int sz, int k, int i){
        if(i == sz) return 1;

        int ans = solve(nums, sz, k, i+1);
        if(nums[i]-k <= 0 || (freq[nums[i] - k] == 0)){
            freq[nums[i]]++;
            ans += solve(nums, sz, k, i+1);
            freq[nums[i]]--;
        }

        return ans;
    }
}