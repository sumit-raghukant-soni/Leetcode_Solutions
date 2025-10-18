class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int sz = nums.length, cnt = 0, curr;
        Set<Integer> used = new HashSet<>();
        Arrays.sort(nums);

        curr = nums[0] - k;
        for(int i=0; i<sz; i++){
            if(curr < (nums[i] - k)) curr = nums[i] - k;
            while(used.contains(curr)){
                curr++;
            }
            if(Math.abs(curr - nums[i]) <= k){
                cnt++;
                used.add(curr);
                curr++;
            }
        }

        return cnt;
    }
}