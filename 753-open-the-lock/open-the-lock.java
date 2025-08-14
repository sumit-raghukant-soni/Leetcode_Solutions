class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> st = new HashSet<>();
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Set<String> vis = new HashSet<>();

        for(String str : deadends) st.add(str);

        if(st.contains("0000")) return -1;

        q.add(new Pair("0000", 0));
        vis.add("0000");
        while(!q.isEmpty()){
            String curr = q.peek().getKey();
            StringBuilder str = new StringBuilder(curr);
            int cnt = q.poll().getValue();
            if(curr.equals(target)) return cnt;
            
            // System.out.println(curr);
            for(int i=0; i<4; i++){
                int f = curr.charAt(i) - '0';
                str.setCharAt(i, (char) ((f < 9 ? f+1 : 0) + '0'));
                String tmp = str.toString();
                str.setCharAt(i, curr.charAt(i));
                if(!vis.contains(tmp) && !st.contains(tmp)){
                    q.add(new Pair(tmp, cnt+1));
                    vis.add(tmp);
                }
                str.setCharAt(i, (char) ((f > 0 ? f-1 : 9) + '0'));
                tmp = str.toString();
                str.setCharAt(i, curr.charAt(i));
                if(!vis.contains(tmp) && !st.contains(tmp)){
                    q.add(new Pair(tmp, cnt+1));
                    vis.add(tmp);
                }
            }
        }

        return -1;
    }
}