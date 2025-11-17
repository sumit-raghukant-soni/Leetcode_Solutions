class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int sz = nums.length, lastused = -1;

        for(int i=0; i<sz; i++){
            // System.out.println(lastused + " " + i + " " + (i - lastused - 1));
            if(nums[i] == 1 && (lastused == -1 || (i - lastused - 1) >= k)) lastused = i;
            else if(nums[i] == 1) return false;
        }

        return true;
    }
}