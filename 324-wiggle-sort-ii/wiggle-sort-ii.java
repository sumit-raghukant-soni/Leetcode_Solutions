class Solution {
    public void wiggleSort(int[] nums) {
        int sz = nums.length, ans[] = new int[sz];

        Arrays.sort(nums);

        for(int i=(sz-1)/2, k=0; k<sz; i--, k+=2){
            ans[k] = nums[i];
        }
        for(int i=sz-1, k=1; k<sz; i--, k+=2){
            ans[k] = nums[i];
        }

        for(int i=0; i<sz; i++){
            nums[i] = ans[i];
        }
    }
}