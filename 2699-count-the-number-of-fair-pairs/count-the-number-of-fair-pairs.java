class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int sz = nums.length, ans = 0;
        Arrays.sort(nums);
        
        long upperPairs = lower_bound(nums, upper);
        long lowerPairs = lower_bound(nums, lower-1);
        
        return upperPairs - lowerPairs;
    }

    private long lower_bound(int []nums, int key){
        int i=0, j=nums.length-1;
        long pairs = 0;

        while(j != 0){
            while(i<j && nums[i] + nums[j] <= key){
                i++;
            }
            pairs += Math.min(i, j);
            j--;
        }

        return pairs;
    }
}