class Solution {
    public long findScore(int[] nums) {
        int sz = nums.length;
        long ans = 0;
        Set<Integer> st = new HashSet<>();
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> 
            {
                if(a.getKey().compareTo(b.getKey()) != 0) return a.getKey().compareTo(b.getKey());
                else return a.getValue() - b.getValue();
            }
        );

        for(int i=0; i<sz; i++){
            pq.add(new Pair(nums[i] * 1L, i));
        }
        
        while(!pq.isEmpty()){
            Pair<Long, Integer> p = pq.poll();
            int i = p.getValue();
            if(st.contains(i)) continue;
            ans += p.getKey();
            st.add(i-1);
            st.add(i+1);
        }

        return ans;
    }
}