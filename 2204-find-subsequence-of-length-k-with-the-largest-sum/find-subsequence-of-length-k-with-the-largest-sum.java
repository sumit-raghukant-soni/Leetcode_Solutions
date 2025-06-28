class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int sz = nums.length, j = 0;
        int ans[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return nums[a] - nums[b];
        });

        for(int i=0; i<sz; i++){
            if(pq.size() < k) pq.add(i);
            else if(nums[pq.peek()] < nums[i]){
                pq.poll();
                pq.add(i);
            }
        }

        for(int i=0; i<sz; i++){
            if(pq.contains(i)){
                ans[j++] = nums[i];
                pq.remove(i);
            }
        }

        return ans;
    }
}