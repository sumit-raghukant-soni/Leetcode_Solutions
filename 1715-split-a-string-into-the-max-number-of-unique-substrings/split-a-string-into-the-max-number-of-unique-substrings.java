class Solution {
    public Integer ans;
    public void solve(String s, int sz, HashMap<String, Integer> mp, int ind){
        if(ind == sz){
            ans = Math.max(ans, mp.size());
            // for(Map.Entry<String, Integer> p : mp.entrySet()){
            //     System.out.println(p.getKey() + " " + p.getValue());
            // }
            // System.out.println(mp.size());
        }

        String tmp = "";
        for(int i=ind; i<sz; i++){
            tmp += s.charAt(i);
            if(!mp.containsKey(tmp)){
                mp.put(tmp, 1);
                solve(s, sz, mp, i+1);
                mp.remove(tmp);
            }
            else solve(s, sz, mp, i+1);
        }
    }
    public int maxUniqueSplit(String s) {
        int sz = s.length();
        ans = 1;
        HashMap<String, Integer> mp = new HashMap<>();

        solve(s, sz, mp, 0);

        return ans;
    }
}