class Solution {
    public int specialTriplets(int[] nums) {
        int sz = nums.length;
        long ans = 0;
        int MOD = 1000000007;
        Map<Integer, Integer> pre = new HashMap<>(), suf = new HashMap<>();
        
        for(int i=1; i<sz; i++){
            suf.put(nums[i], suf.getOrDefault(nums[i], 0) + 1);
        }

        pre.put(nums[0], 1);
        for(int i=1; i<sz-1; i++){
            suf.put(nums[i], suf.get(nums[i]) - 1);
            int a = pre.getOrDefault(nums[i]*2, 0);
            int b = suf.getOrDefault(nums[i]*2, 0);
            pre.put(nums[i], pre.getOrDefault(nums[i], 0) + 1);
            if(a == 0 || b == 0) continue;
            ans += (1L * (a%MOD) * (b%MOD)) % MOD;
            ans = ans%MOD;
        }

        return (int) ans;
    }
}