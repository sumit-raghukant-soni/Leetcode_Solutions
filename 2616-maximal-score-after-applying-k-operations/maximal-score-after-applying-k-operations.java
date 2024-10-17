class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        for(int i=0; i<k; i++){
            int tmp = pq.peek();
            // System.out.println(tmp + " " + Math.ceil(tmp/3.0));
            pq.remove(tmp);
            pq.add((int) Math.ceil(tmp/3.0));
            ans += tmp;
        }

        return ans;
    }
}