class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int sz1 = bottom.length(), sz2 = allowed.size();
        PriorityQueue<String> q = new PriorityQueue<>();
        Map<String, Set<Character>> mp = new HashMap<>();
        Set<String> vis = new HashSet<>();

        for(String str : allowed){
            String key = str.substring(0,2);
            if(!mp.containsKey(key)){
                mp.put(key, new HashSet<>());
            }
            mp.get(key).add(str.charAt(2));
        }

        // System.out.println(mp);
        q.add(bottom);

        while(!q.isEmpty()){
            String curr = q.poll();
            if(vis.contains(curr)) continue;
            vis.add(curr);
            int sz = curr.length();
            if(sz == 1) return true;
            List<String> lst = new ArrayList<>();
            List<String> lst2 = new ArrayList<>();

            // System.out.println(curr);
            for(int i=0; i<sz-1; i++){
                String sub = curr.charAt(i) + "" + curr.charAt(i+1);
                if(!mp.containsKey(sub)) {
                    lst.clear();
                    break;
                }
                if(i == 0){
                    for(char ch : mp.get(sub)){
                        lst2.add(ch + "");
                    }
                }
                else{
                    for(char ch : mp.get(sub)){
                        for(String s : lst){
                            lst2.add(s + ch);
                        }
                    }
                }
                lst.clear();
                lst.addAll(lst2);
                lst2.clear();
            }
            // System.out.println(lst);
            for(String str : lst) q.add(str);
        }

        return false;
    }
}