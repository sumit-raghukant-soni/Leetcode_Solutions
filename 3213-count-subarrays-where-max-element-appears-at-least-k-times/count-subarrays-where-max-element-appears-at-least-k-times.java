class Solution {
    public long countSubarrays(int[] nums, int k) {
        int sz = nums.length, maxi = nums[0];
        long ans = 0, last = -1;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<sz; i++) maxi = Math.max(maxi, nums[i]);
        
        for(int i=0; i<sz; i++){
            if(nums[i] == maxi) q.add(i);
            if(q.size() == k){
                int front = q.poll();
                ans += 1L * (front - last) * (sz-i);
                last = front;
            }
        }

        return ans;
    }
}