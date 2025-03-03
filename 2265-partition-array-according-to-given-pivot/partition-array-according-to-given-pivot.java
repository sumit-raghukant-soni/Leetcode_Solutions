class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int sz = nums.length, k1=0, k2=0;
        int[] ans = new int[sz];

        for(int i=0; i<sz; i++){
            if(nums[i] < pivot){
                ans[k1++] = nums[i];
            }
            else if(nums[i] == pivot) k2++;
        }

        for(int i=0; i<k2; i++){
            ans[k1++] = pivot;
        }

        for(int i=0; i<sz; i++){
            if(nums[i] > pivot) ans[k1++] = nums[i];
        }

        return ans;
    }
}