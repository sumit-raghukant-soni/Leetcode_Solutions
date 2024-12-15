class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int sz = classes.length;
        Double tp = 0.0, avg, preAvg;
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> 
            b.getKey().compareTo(a.getKey())
        );

        for(int i=0; i<sz; i++){
            avg = (1.0*classes[i][0]+1) / (classes[i][1]+1); 
            preAvg = 1.0*classes[i][0] / classes[i][1];
            pq.offer(new Pair(avg - preAvg, i));
        }

        while(!pq.isEmpty() && extraStudents > 0){
            Pair<Double, Integer> curr = pq.poll();
            classes[curr.getValue()][0]++;
            classes[curr.getValue()][1]++;
            extraStudents--;
            avg = (1.0*classes[curr.getValue()][0]+1) / (classes[curr.getValue()][1]+1);
            preAvg = 1.0*classes[curr.getValue()][0] / classes[curr.getValue()][1];
            pq.offer(new Pair(avg - preAvg, curr.getValue()));
        }

        for(int i=0; i<sz; i++){
            tp += (double) classes[i][0] / classes[i][1];
        }

        return tp/sz;
    }
}