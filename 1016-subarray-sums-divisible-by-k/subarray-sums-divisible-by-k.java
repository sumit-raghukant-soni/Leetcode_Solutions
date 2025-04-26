class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sz = nums.length, curr = 0, psum = 0;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        mp.put(0, 1);
        for(int i=0; i<sz; i++){    
            curr = (curr + (nums[i]%k) + k) % k;
            ans += mp.getOrDefault(curr, 0);
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
}