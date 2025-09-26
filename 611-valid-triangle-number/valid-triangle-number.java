class Solution {
    public int triangleNumber(int[] nums) {
        int sz = nums.length, cnt = 0;

        Arrays.sort(nums);

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                for(int k=j+1; k<sz; k++){
                    if( ((nums[i] + nums[j]) > nums[k]) && ( (nums[i] + nums[k]) > nums[j]) && ( (nums[k] + nums[j]) > nums[i])) cnt++;
                }
            }
        }

        return cnt;
    }
}