class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int sz = nums.length;
        long ans = 0, tmp = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            tmp += nums[i];
            if(mp.containsKey(nums[i])) mp.put(nums[i], mp.get(nums[i]) + 1);
            else mp.put(nums[i], 1);

            // System.out.println(tmp + " " + mp.size());
            if(i >= k-1){
                if(mp.size() == k) ans = Math.max(ans, tmp);
                // System.out.println(tmp + " ans " + mp.size());
                tmp -= nums[i-(k-1)];
                if(mp.containsKey(nums[i-(k-1)])) mp.put(nums[i-(k-1)], mp.get(nums[i-(k-1)])-1);

                if(mp.containsKey(nums[i-(k-1)]) && mp.get(nums[i-(k-1)]) == 0) mp.remove(nums[i-(k-1)]);
            }
        }

        return ans;
    }
}