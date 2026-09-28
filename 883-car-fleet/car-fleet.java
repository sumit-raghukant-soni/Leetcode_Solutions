class Solution {
    public int carFleet(int target, int[] pos, int[] spd) {
        int sz = pos.length;
        List<Integer[]> lst = new ArrayList<>();
        Deque<Double> q = new ArrayDeque<>();

        for(int i=0; i<sz; i++) {
            lst.add(new Integer[]{ pos[i], spd[i] });
        }

        lst.sort((a, b) -> a[0] - b[0]);

        for(int i=0; i<sz; i++) {
            // timeToReach ;)
            double ttr = (target-lst.get(i)[0] * 1.0)/ lst.get(i)[1];
            while(!q.isEmpty() && q.getFirst() <= ttr) {
                q.removeFirst();
            }
            q.addFirst(ttr);
        }

        return q.size();
    }
}