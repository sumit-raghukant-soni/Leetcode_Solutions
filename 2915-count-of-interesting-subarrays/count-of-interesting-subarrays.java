class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int sz = nums.size(), lastInd = -1;
        long ans = 0, pre = 0;
        Map<Long, Integer> mp = new HashMap<>();

        mp.put(0L, 1);
        for(int i=0; i<sz; i++){
            pre += (nums.get(i)%modulo == k) ? 1 : 0;
            ans += mp.getOrDefault((pre - k + modulo) % modulo, 0);
            mp.put( (pre % modulo), mp.getOrDefault(pre % modulo, 0) + 1 );
        }

        return ans;
    }
}