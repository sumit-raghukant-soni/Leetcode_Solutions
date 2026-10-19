class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int sz = nums.length;
        List<Integer> lst = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<sz; i++) {
            if(nums[i] == target) {
                lst.add(i);
            }
        }

        return lst;
    }
}