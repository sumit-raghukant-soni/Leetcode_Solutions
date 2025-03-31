class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private Set<List<Integer>> allSub = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> tmp = new ArrayList<>();

        solve(nums, tmp, 0);

        ans.addAll(allSub);
        
        return ans;
    }

    private void solve(int[] nums, List<Integer> tmp, int i){
        int sz = nums.length;
        if(tmp.size() >= 2){
            List<Integer> t = new ArrayList<>();
            t.addAll(tmp);
            allSub.add(t);
        }
        if(i == sz) return;

        solve(nums, tmp, i+1);
        if(tmp.isEmpty() || tmp.get(tmp.size()-1) <= nums[i]){
            tmp.add(nums[i]);
            solve(nums, tmp, i+1);
            tmp.remove(Integer.valueOf(nums[i]));
        }
    }
}