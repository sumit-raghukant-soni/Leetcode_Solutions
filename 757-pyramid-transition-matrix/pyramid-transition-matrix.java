class Solution {
    private Map<String, Set<Character>> mp = new HashMap<>();
    private Set<String> st = new HashSet<>(), newSt = new HashSet<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int sz = allowed.size();

        for(int i=0; i<sz; i++){
            String base = allowed.get(i).substring(0, 2);
            Character ch = allowed.get(i).charAt(2);
            if(!mp.containsKey(base)) mp.put(base, new HashSet<>());
            mp.get(base).add(ch);
        }

        // System.out.println(mp);

        // solve(0, bottom, "");
        newSt.add(bottom);
        sz = bottom.length();
        while(--sz > 0){
            // System.out.println(newSt + " " + sz);
            if(newSt.isEmpty()) return false;
            st.clear();
            st.addAll(newSt);
            newSt.clear();
            for(String tmp : st){
                solve(0, tmp, "");
            }
            // System.out.println(newSt);
        }

        return !newSt.isEmpty();
    }

    private void solve(int i, String str, String newStr){
        if(i == str.length()-1){
            newSt.add(newStr);
            return;
        }
        if(!mp.containsKey(str.substring(i, i+2))) return;

        // System.out.println( str + " " + str.substring(i, i+2) + " new " + newStr);
        for( char ch : mp.get(str.substring(i, i+2)) ){
            solve(i+1, str, newStr + ch);
        }
        
    }
}