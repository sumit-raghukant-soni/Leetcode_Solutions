class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Integer[] tmp = {x, 0};
        pq.add(tmp);
        int mini = 0, maxi = x + 11;
        Set<Integer> vis = new HashSet<>();
        

        while(!pq.isEmpty()){
            int curr = pq.peek()[0], steps = pq.peek()[1];
            pq.poll();
            if(vis.contains(curr)) continue;
            if(curr == y) return steps;
            
            vis.add(curr);
            steps++;
            if(curr%11 == 0){
                tmp = new Integer[2];
                tmp[1] = steps;
                tmp[0] = curr/11;
                pq.add(tmp);
            }
            if(curr%5 == 0){
                tmp = new Integer[2];
                tmp[1] = steps;
                tmp[0] = curr/5;
                pq.add(tmp);
            } 
            // if(curr-1 > mini){
                tmp = new Integer[2];
                tmp[1] = steps;
                tmp[0] = curr-1;
                pq.add(tmp);
            // }
            // if(curr+1 <= maxi){
                tmp = new Integer[2];
                tmp[1] = steps;
                tmp[0] = curr+1;
                pq.add(tmp);
            // }
        }

        return -1;
    }
}