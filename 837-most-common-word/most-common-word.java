class Solution {
    public String mostCommonWord(String p, String[] banned) {
        int sz = p.length(), maxi = 0;
        String tmp = "", ans = "";
        HashMap<String, Integer> b = new HashMap<>(), nonBanned = new HashMap<>();

        for(String i : banned){
            b.put(i, 1);
        }

        for(int i=0; i<sz; i++){
            if(p.charAt(i) >= 'a' && p.charAt(i) <= 'z'){
                tmp += p.charAt(i);
            }
            else if(p.charAt(i) >= 'A' && p.charAt(i) <= 'Z'){
                tmp += (char)((int) p.charAt(i) ^ 32);
            }
            else{
                if(!tmp.isEmpty() && !b.containsKey(tmp)){
                    // System.out.println(tmp + " = " + nonBanned.get(tmp));
                    if(nonBanned.containsKey(tmp)) nonBanned.put(tmp, nonBanned.get(tmp) + 1);
                    else nonBanned.put(tmp, 1);
                }
                tmp = "";
            }
        }
        if(!tmp.isEmpty() && !b.containsKey(tmp)){
            if(nonBanned.containsKey(tmp)) nonBanned.put(tmp, nonBanned.get(tmp) + 1);
            else nonBanned.put(tmp, 1);
        }

        for(Map.Entry<String, Integer> pair : nonBanned.entrySet()){
            // System.out.println(pair.getKey() + " " + pair.getValue());
            if(pair.getValue() > maxi){
                maxi = pair.getValue();
                ans = pair.getKey();
            }
        }

        return ans;
    }
}