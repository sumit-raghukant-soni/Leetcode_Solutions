class Solution {
    public int maximumLength(String s) {
        int sz = s.length(), ans = -1;
        String tmp = "";
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            char ch = s.charAt(i);
            int j=i;
            tmp = "";
            while(j < sz && s.charAt(j) == ch){
                tmp += s.charAt(j++);
                mp.put(tmp, mp.getOrDefault(tmp, 0) + 1);
            }
        }

        for(Map.Entry<String, Integer> pair : mp.entrySet()){
            if(pair.getValue() >= 3){
                ans = Math.max(ans, pair.getKey().length());
            }
        }

        return ans;
    }
}