class Solution {
    public int maximumLength(int[] nums, int k) {
        int sz = nums.length, ans = 0;
        boolean flg = false;
        int mp[] = new int[k];

        for(int i=0; i<k; i++){
            Arrays.fill(mp, 0);
            for(int j=0; j<sz; j++){
                mp[nums[j]%k] = mp[(i - (nums[j]%k) + k)%k] + 1;
            }

            for(int j : mp){
                ans = ans > j ? ans : j;
            }
        }


        return ans;
    }
}