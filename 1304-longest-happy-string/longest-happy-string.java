class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue< Pair<Integer, Character> > pq = new PriorityQueue<>((x, y) -> (y.getKey() - x.getKey()));

        if(a > 0) pq.add(new Pair<>(a, 'a'));
        if(b > 0) pq.add(new Pair<>(b, 'b'));
        if(c > 0) pq.add(new Pair<>(c, 'c'));

        String ans = "";

        while(!pq.isEmpty()){
            Pair<Integer, Character> top1 = pq.peek();
            pq.remove(top1);
            if(ans.length() >= 2 && ans.charAt(ans.length() - 1) == top1.getValue() && ans.charAt(ans.length() - 2) == top1.getValue()){
                if(pq.isEmpty()) break;

                Pair<Integer, Character> top2 = pq.peek();
                pq.remove(top2);
                ans = ans + top2.getValue() + top1.getValue();
                
                if(top2.getKey() > 1){
                    pq.add(new Pair<>(top2.getKey()-1, top2.getValue()));
                }
            }
            else{
                ans = ans + top1.getValue();
            }
            if(top1.getKey() > 1){
                pq.add(new Pair<>(top1.getKey()-1, top1.getValue()));
            }
        }
        return ans;
    }
}