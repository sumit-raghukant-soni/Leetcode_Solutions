class Solution {
    public int ans = 0, maxi = 0;
    public int countMaxOrSubsets(int[] nums) {
        int sz = nums.length;

        for(int i=0; i<sz; i++){
            maxi = maxi | nums[i];
        }
        
        solve(nums, sz, 0, 0);

        return ans;
    }

    private void solve(int[] nums, int sz, int i, int sum){
        if(i == sz) return;

        solve(nums, sz, i+1, sum);
        sum = sum|nums[i];
        if(sum == maxi) ans++;
        solve(nums, sz, i+1, sum);
    }
}