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
            int cnt = q.poll().getValue();
            if(curr.equals(target)) return cnt;
            
            // System.out.println(curr);
            int f = curr.charAt(0) - '0',s = curr.charAt(1) - '0',t = curr.charAt(2) - '0',fr = curr.charAt(3) - '0';
            String tmp = (char) ((f < 9 ? f+1 : 0) + '0') + curr.substring(1);
            // System.out.println("1st " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }
            tmp = (char) ((f > 0 ? f-1 : 9) + '0') + curr.substring(1);
            // System.out.println("2nd " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }

            tmp = curr.substring(0, 1) + ((char) ((s < 9 ? s+1 : 0) + '0')) + curr.substring(2);
            // System.out.println("3rd " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }
            tmp = curr.substring(0, 1) + ((char) ((s > 0 ? s-1 : 9) + '0')) + curr.substring(2);
            // System.out.println("4th " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }

            tmp = curr.substring(0,2) + (char) ((t < 9 ? t+1 : 0) + '0') + curr.substring(3, 4);
            // System.out.println("5th " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }
            tmp = curr.substring(0,2) + (char) ((t > 0 ? t-1 : 9) + '0') + curr.substring(3, 4);
            // System.out.println("6th " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }

            tmp = curr.substring(0,3) + (char) ((fr < 9 ? fr+1 : 0) + '0');
            // System.out.println("7th " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }
            tmp = curr.substring(0,3) + (char) ((fr > 0 ? fr-1 : 9) + '0');
            // System.out.println("8th " + tmp);
            if(!vis.contains(tmp) && !st.contains(tmp)){
                q.add(new Pair(tmp, cnt+1));
                vis.add(tmp);
            }
        }

        return -1;
    }
}