class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private Set<List<Integer>> allSub = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> tmp = new ArrayList<>();

        solve(nums, tmp, -101, 0);

        ans.addAll(allSub);
        
        return ans;
    }

    private void solve(int[] nums, List<Integer> tmp, int last, int i){
        int sz = nums.length;
        if(tmp.size() >= 2){
            List<Integer> t = new ArrayList<>();
            t.addAll(tmp);
            allSub.add(t);
        }
        if(i == sz) return;

        solve(nums, tmp, last, i+1);
        if(last <= nums[i]){
            tmp.add(nums[i]);
            solve(nums, tmp, nums[i], i+1);
            tmp.remove(Integer.valueOf(nums[i]));
        }
    }
}