class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int sz = nums.length, needed = 0;
        int ans[] = new int[2], k=0;
        Arrays.sort(nums);

        for(int i=0; i<sz; i++){
            if(nums[i] != needed){
                ans[k++] = nums[i];
            }
            else needed++;
        }

        return ans;
    }
}