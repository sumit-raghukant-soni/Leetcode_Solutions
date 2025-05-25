class Solution {
    public int longestPalindrome(String[] words) {
        int sz = words.length, ans = 0, single = 0;
        String rev = null;
        Map<String, Integer> st = new HashMap<>();
        Set<String> vis = new HashSet<>();

        for(int i=0; i<sz; i++){
            st.put(words[i], st.getOrDefault(words[i], 0) + 1);
        }

        for(Map.Entry<String, Integer> e : st.entrySet()){
            String str = e.getKey();
            rev = str.charAt(1) + "" + str.charAt(0);
            if(!vis.contains(str) && !vis.contains(rev) && !str.equals(rev) && st.containsKey(rev)){
                ans += Math.min(st.get(rev), st.get(str)) * 2;
                vis.add(rev);
                vis.add(str);
            }
        }

        for(Map.Entry<String, Integer> e : st.entrySet()){
            String str = e.getKey();
            int count = e.getValue();
            if(vis.contains(str)) continue;
            rev = str.charAt(1) + "" + str.charAt(0);
            if(str.equals(rev)){
                if(count%2 == 0){
                    ans += count;
                }
                else{
                    ans += count-1;
                    single = 1;
                }
            }
        }

        return (ans + single) * 2;

    }
}