class Solution {
    public int minOperations(int[] nums, int k) {
        int sz = nums.length, j, cnt = 0;
        Arrays.sort(nums);

        for(int i=0; i<sz; i++){
            if(nums[i] < k) return -1;
            j = i;
            while(j < sz && nums[j] == nums[i]){
                j++;
            }
            i = j-1;
            if(nums[i] != k) cnt++;
        }

        return cnt;
    }
}