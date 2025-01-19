class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        PriorityQueue< Pair<Integer, Integer> > pq = new PriorityQueue<>((a, b) -> (a.getKey()+a.getValue() - target) - (b.getKey()+b.getValue() - target));
        Set<Pair<Integer, Integer>> st = new HashSet<>();

        pq.add(new Pair(0, 0));
        st.add(pq.peek());

        while(!pq.isEmpty()){
            int cx = pq.peek().getKey(), cy = pq.peek().getValue();
            // System.out.println(cx + " " + cy);
            // System.out.println(Math.max((cx-(y-cy)), 0) + "," + ((cy+cx)>y? y : (cx+cy)) + " " + ((cy+cx)>x? x : (cx+cy)) + "," + Math.max(0, (cy-(x-cx))));
            
            pq.poll();
            if(cx+cy == target) return true;
            Pair<Integer, Integer> a = new Pair(0, cy), b = new Pair(cx, 0);
            Pair<Integer, Integer> e = new Pair(x, cy), f = new Pair(cx, y);
            Pair<Integer, Integer> c = new Pair(Math.max((cx-(y-cy)), 0), ((cy+cx)>y? y : (cx+cy))), 
            d = new Pair(((cy+cx)>x? x : (cx+cy)), Math.max(0, (cy-(x-cx))) );
            if(!st.contains(a)){
                pq.add(a);
                st.add(a);
            }
            if(!st.contains(b)){
                pq.add(b);
                st.add(b);
            } 
            if(!st.contains(c)){
                pq.add(c);
                st.add(c);
            } 
            if(!st.contains(d)){
                pq.add(d);
                st.add(d);
            } 
            if(!st.contains(e)){
                pq.add(e);
                st.add(e);
            } 
            if(!st.contains(f)){
                pq.add(f);
                st.add(f);
            } 
        }

        return false;
    }
}