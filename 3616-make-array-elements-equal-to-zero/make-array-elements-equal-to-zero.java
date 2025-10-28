class Solution {
    public int countValidSelections(int[] nums) {
        int sz = nums.length, pre[] = new int[sz], suf[] = new int[sz];
        int ans = 0, val = 0;
        
        for(int i=0; i<sz; i++){
            val += nums[i];
            pre[i] = val;
        }

        val = 0;
        for(int i=sz-1; i>=0; i--){
            val += nums[i];
            suf[i] = val;
        }

        for(int i=0; i<sz; i++){
            // System.out.println(nums[i] + " " + pre[i] + ":" + suf[i]);
            if(nums[i] == 0){
                if(pre[i] == suf[i]){
                    ans+=2;
                }
                else if(Math.abs(pre[i] - suf[i]) == 1){
                    ans++;
                }
            }
        }

        return ans;
    }
}