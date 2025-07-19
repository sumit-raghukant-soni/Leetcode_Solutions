class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int sz = arr.length, ans[] = new int[2];
        Double[] tmp = null;
        PriorityQueue<Double[]> pq = new PriorityQueue<>((a, b) -> a[2].compareTo(b[2]));

        for(int i=0; i<sz-1; i++){
            for(int j=i+1; j<sz; j++){
                tmp = new Double[3];
                tmp[0] = arr[i] * 1.0;
                tmp[1] = arr[j] * 1.0;
                tmp[2] = arr[i]/(1.0*arr[j]);
                pq.add(tmp);
            }
        }

        for(int i=1; i<k; i++) pq.poll();

        ans[0] = (int) Math.round(pq.peek()[0]);
        ans[1] = (int) Math.round(pq.peek()[1]);
        return ans;
    }
}