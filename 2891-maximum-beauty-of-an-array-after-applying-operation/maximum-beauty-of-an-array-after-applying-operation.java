class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int sz = nums.length, ans = 0;

        Arrays.sort(nums);

        int j = 0, cnt = 0, upper = nums[0]+k;
        for(int i=0; i<sz; i++){
            cnt++;
            if((nums[i] - k) > upper) {
                while(j < i && (nums[j]+k) < (nums[i]-k)){
                    j++;
                    cnt--;
                }
                upper = nums[j]+k;
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}