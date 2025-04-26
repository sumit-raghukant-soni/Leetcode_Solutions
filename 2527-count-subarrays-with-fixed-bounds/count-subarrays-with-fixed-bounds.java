class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int sz = nums.length;
        long ans = 0, start, lastmin = 0, lastmax = 0, maxCnt, minCnt;

        for(int i=0; i<sz; i++){
            start = i;
            minCnt = 0; maxCnt = 0;

            while(i < sz && nums[i] >= minK && nums[i] <= maxK){
                if(nums[i] == minK){
                    minCnt++;
                    lastmin = i;
                    if(maxCnt != 0 && nums[i] != maxK){
                        ans += lastmax - start + 1;
                    }
                }
                if(nums[i] == maxK){
                    maxCnt++;
                    lastmax = i;
                    if(minCnt != 0 && nums[i] != minK){
                        ans += lastmin - start + 1;
                    }
                }
                if(nums[i] != minK && nums[i] != maxK && minCnt != 0 && maxCnt != 0){
                    ans += Math.min( lastmax, lastmin ) - start + 1;
                }
                i++;
            }
            if(minK == maxK){
                ans += (1L*minCnt*(minCnt+1))/2;
            }
        }

        return ans;
    }
}