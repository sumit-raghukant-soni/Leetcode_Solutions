class Solution {
    private TreeSet<Integer> uniq = new TreeSet<>();
    private Map<Integer, Integer> mp = new HashMap<>();
    private int[] dp = null;
    public int deleteAndEarn(int[] nums) {
        int sz = nums.length, ans = 0;

        for(int i=0; i<sz; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            uniq.add(nums[i]);
        }

        dp = new int[uniq.size()];
        ans = solve(uniq.toArray(new Integer[0]), uniq.size(), 0);

        return ans;
    }

    private int solve(Integer[] arr, int sz, int i){
        if(i >= sz) return 0;
        if(dp[i] != 0) return dp[i];

        int take = arr[i] * mp.get(arr[i]);
        if(i+1 < sz && arr[i+1] == arr[i]+1) take += solve(arr, sz, i+2);
        else take += solve(arr, sz, i+1);
        int notTake = solve(arr, sz, i+1);

        return dp[i] = take > notTake ? take : notTake;
    }
}