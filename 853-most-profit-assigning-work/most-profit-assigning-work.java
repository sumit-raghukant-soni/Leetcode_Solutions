class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sz1 = difficulty.length, sz2 = worker.length, sum = 0, j = 0;
        List<Pair<Integer, Integer>> pq = new ArrayList<>();
        Arrays.sort(worker);

        for(int i=0; i<sz1; i++){
            pq.add(new Pair(profit[i], difficulty[i]));
        }
        Collections.sort(pq, (a, b) -> b.getKey() - a.getKey());

        for(int i=sz2-1; i>=0 && j<sz1; i--){
            int p = pq.get(j).getKey(), d = pq.get(j).getValue();
            while(d > worker[i]){
                j++;
                if(j == sz1){
                    p = 0;
                    break;
                }
                p = pq.get(j).getKey(); 
                d = pq.get(j).getValue();
            }
            sum += p;
        }

        return sum;
    }
}