class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int sz = nums.length, ans[] = new int[sz-k+1], flg=0;

        for(int i=0; i<sz; i++){
            if(i-1 < 0 || nums[i-1] != nums[i]-1) flg = 0;
            flg++;
            if(i >= k-1 && flg == k){
                ans[i-k+1] = nums[i];
                flg--;
            }
            else if(i >= k-1) ans[i-k+1] = -1; 
        }

        return ans;
    }
}