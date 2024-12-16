class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int sz = nums.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(!a.getKey().equals(b.getKey()))  return a.getKey().compareTo(b.getKey());
            else return a.getValue().compareTo(b.getValue());
        });

        for(int i=0; i<sz; i++){
            pq.add(new Pair(nums[i], i));
        }

        while(k-- > 0){
            Pair<Integer, Integer> p = pq.poll();
            nums[p.getValue()] *= multiplier;
            pq.add(new Pair(nums[p.getValue()], p.getValue()));
        }

        return nums;
    }
}