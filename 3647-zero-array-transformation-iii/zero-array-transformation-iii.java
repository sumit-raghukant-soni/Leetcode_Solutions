class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int sz1 = nums.length, sz2 = queries.length;
        int tmp[] = new int[sz1+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;

        Arrays.sort(queries, (a, b) -> {
            return a[0] - b[0];
        });

        int val = 0, j = 0;
        for(int i=0; i<sz1; i++){
            val += tmp[i];
            while(j < sz2 && queries[j][0] == i){
                pq.add(queries[j][1]);
                j++;
            }
            while(val < nums[i] && !pq.isEmpty() && pq.peek() >= i){
                val++;
                tmp[pq.poll() + 1]--;
            }
            if(val < nums[i]) return -1;
        }

        return pq.size();
    }
}