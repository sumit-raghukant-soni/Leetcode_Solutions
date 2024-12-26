class Solution {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sz = nums.length;
        Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();

        return solve(dp, nums, sz, target, 0);
    }
    private int solve(Map<Pair<Integer, Integer>, Integer> dp, int[] nums, int sz, int target, int i){
        if(i == sz){
            if(target == 0) return 1;
            return 0;
        }
        
        if(dp.containsKey(new Pair(i, target))) return dp.get(new Pair(i, target));
        
        int add = solve(dp, nums, sz, target+nums[i], i+1);
        int minus = solve(dp, nums, sz, target-nums[i], i+1);
        
        dp.put(new Pair(i, target), add + minus);
        return dp.get(new Pair(i, target));
    }   
}