class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int sz = trips.length, curr = 0;
        PriorityQueue<Pair<Integer, Integer>> st = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        for(int i=0; i<sz; i++){
            curr = trips[i][1];
            while(!st.isEmpty() && curr >= st.peek().getKey()){
                capacity += st.peek().getValue();
                st.poll();
            }

            // System.out.println(curr + " " + capacity);
            if(capacity < trips[i][0]) return false;

            capacity -= trips[i][0];
            st.add(new Pair(trips[i][2], trips[i][0]));
            // System.out.println("2.0 " + curr + " " + capacity);
        }

        return true;
    }
}