class Solution {
    public int maximumLength(int[] nums, int k) {
        int sz = nums.length, ans = 0, val;
        boolean flg = false;
        int mp[] = new int[k];

        for(int i=0; i<k; i++){
            Arrays.fill(mp, 0);
            for(int j=0; j<sz; j++){
                val = nums[j]%k;
                mp[val] = mp[(i - (val) + k)%k] + 1;
                ans = ans > mp[val] ? ans : mp[val];
            }
        }


        return ans;
    }
}