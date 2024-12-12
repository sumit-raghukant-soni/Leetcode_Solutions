class Solution {
    public long pickGifts(int[] gifts, int k) {
        int sz = gifts.length;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for(int i=0; i<sz; i++){
            pq.add(gifts[i]);
        }

        for(int i=0; i<k; i++){
            pq.add((int) Math.floor(Math.sqrt(pq.poll())));
        }

        while(!pq.isEmpty()){
            ans += pq.poll();
        }

        return ans;
    }
}