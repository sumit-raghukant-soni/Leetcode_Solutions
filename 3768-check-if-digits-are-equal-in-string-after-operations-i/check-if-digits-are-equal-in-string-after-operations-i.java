class Solution {
    public boolean hasSameDigits(String s) {
        int sz = s.length();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<sz; i++){
            q.add(s.charAt(i) - '0');
        }

        while(sz > 2){
            for(int i=0; i<sz-1; i++){
                int a = q.poll(), b = q.peek();
                // System.out.println(a + " " + b);
                q.add( (a + b) % 10 );
            }
            q.poll();
            // System.out.println(q);
            sz = q.size();
        }

        return q.poll() == q.poll();
    }
}