class Solution {
    public double maxAverageRatio(int[][] classes, int es) {
        int sz = classes.length;
        double ans = 0;
        Double tmp[];
        PriorityQueue<Double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]) );

        for(int i=0; i<sz; i++){
            if(classes[i][0] != classes[i][1]){
                tmp = new Double[3];
                tmp[0] = (double) classes[i][0];
                tmp[1] = (double) classes[i][1];
                tmp[2] = ((tmp[0]+1)/ (tmp[1]+1)) - (tmp[0]/ tmp[1]);
                pq.add(tmp);
            }
            ans += (1.0 * classes[i][0]) / classes[i][1];
        }

        // System.out.println(ans);

        while(es-- > 0 && !pq.isEmpty()){
            tmp = pq.poll();
            // System.out.println(tmp[0] + " " + tmp[1]);
            ans += tmp[2];
            tmp[0]++;
            tmp[1]++;
            tmp[2] = ((tmp[0]+1)/ (tmp[1]+1)) - (tmp[0]/ tmp[1]);
            pq.add(tmp);
        }

        return ans/sz;
    }
}