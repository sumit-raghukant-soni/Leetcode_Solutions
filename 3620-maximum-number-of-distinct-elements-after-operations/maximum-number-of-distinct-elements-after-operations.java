class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int sz = nums.length, cnt = 0, curr;
        Set<Integer> used = new HashSet<>();
        Arrays.sort(nums);

        curr = nums[0] - k;
        for(int i=0; i<sz; i++){
            while(curr < (nums[i] - k) || used.contains(curr)){
                curr++;
            }
            // System.out.println(nums[i] + " " + curr);
            if(Math.abs(curr - nums[i]) <= k){
                cnt++;
                used.add(curr);
                curr++;
            }
        }

        return cnt;
    }
}