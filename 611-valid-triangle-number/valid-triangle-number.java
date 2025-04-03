class Solution {
    public int triangleNumber(int[] nums) {
        int sz = nums.length, ans = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<sz; i++){
            int j = i+1, k = j+1;
            while(nums[i] != 0 && j<(sz-1) && k < sz){
                if(k < sz && (nums[i]+nums[j]) > nums[k]){
                    k++; ans += (k - j-1); 
                }
                else{
                    j++;
                }
            }
        }

        return ans;
    }
}