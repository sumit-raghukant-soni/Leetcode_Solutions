class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int sz = nums.length, j=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()), pq2 = new PriorityQueue<>();

        for(int i=0; i<sz; i++){
            while(!pq.isEmpty() && Math.abs(pq.peek() - nums[i]) > 2){
                ans += pq.size();
                pq2.remove(nums[j]);
                pq.remove(nums[j++]);
            }
            while(!pq2.isEmpty() && Math.abs(pq2.peek() - nums[i]) > 2){
                ans += pq2.size();
                pq.remove(nums[j]);
                pq2.remove(nums[j++]);
            }
            pq.add(nums[i]);
            pq2.add(nums[i]);
        }

        while(!pq.isEmpty()){
            ans += pq.size();
            pq.poll();
        }

        return ans;
    }
}