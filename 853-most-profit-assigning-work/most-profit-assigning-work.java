class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sz1 = difficulty.length, sz2 = worker.length, sum = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        Arrays.sort(worker);

        for(int i=0; i<sz1; i++){
            pq.add(new Pair(profit[i], difficulty[i]));
        }
        // System.out.println(pq);

        for(int i=sz2-1; i>=0 && !pq.isEmpty(); i--){
            int p = pq.peek().getKey(), d = pq.peek().getValue();
            while(d > worker[i]){
                pq.poll();
                if(pq.isEmpty()){
                    p = 0;
                    break;
                }
                p = pq.peek().getKey(); 
                d = pq.peek().getValue();
            }
            // System.out.println(worker[i] + " " + d + ":" + p);
            sum += p;
        }

        return sum;
    }
}