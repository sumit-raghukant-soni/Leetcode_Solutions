class Solution {
    public long beautifulSubarrays(int[] nums) {
        int sz = nums.length, xor = 0;
        long ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            if(!mp.containsKey(xor)) mp.put(xor, 1);
            else mp.put(xor, mp.get(xor) + 1);

            xor = xor ^ nums[i];
            
            ans += mp.getOrDefault(xor, 0);
        }

        return ans;
    }
}