class Solution {
    public int maximumCount(int[] nums) {
        int sz = nums.length;
        int ne = -1, ps = sz;
        int s = 0, e = sz-1, mid;
        
        // ne
        while(s <= e){
            mid = s + (e-s)/2;
            if(nums[mid] < 0){
                ne = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }

        s = 0; e = sz-1;
        // ps
        while(s <= e){
            mid = s + (e-s)/2;
            if(nums[mid] > 0){
                ps = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }

        return Math.max((ne - 0)+1, (sz-ps));
    }
}