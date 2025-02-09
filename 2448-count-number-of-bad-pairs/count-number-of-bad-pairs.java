class Solution {
    public long countBadPairs(int[] nums) {
        int sz = nums.length;
        long ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<sz; i++){
            mp.put(nums[i]-i, mp.getOrDefault(nums[i]-i, 0) + 1);
        }

        // System.out.println(mp);

        long sum = 0;
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            list.add(e.getValue());
            sum += e.getValue();
        }  


        for(int i=0; i<list.size(); i++){
            sum -= list.get(i);
            ans += (long) (list.get(i) * sum);
            // sum += list.get(i);
        }

        return ans;
    }
}