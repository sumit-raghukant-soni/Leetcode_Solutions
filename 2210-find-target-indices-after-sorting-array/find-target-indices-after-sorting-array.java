class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int sz = nums.length, cnt = 0, min = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i : nums) {
            if(i < target) min++;
            else if(i == target) cnt++;
        }

        for(int i=0; i<cnt; i++) {
            ans.add(min + i);
        }

        return ans;
    }
}