class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, cnt = 0;
        int sz = nums.length;

        for(int i=0; i<sz; i++){
            if(nums[i] == 0) cnt++;
            else{
                if(cnt > 0) ans += (cnt * (cnt+1)) / 2;
                cnt = 0;
            }
        }

        if(cnt > 0) ans += (cnt * (cnt+1)) / 2;
        return ans;
    }
}