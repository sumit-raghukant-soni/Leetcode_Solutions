class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int sz1 = wordlist.length, sz2 = queries.length;
        String ans[] = new String[sz2], tmp = null;
        Set<String> st = new HashSet<>();
        Map<String, String> mp1 = new HashMap<>(), mp2 = new HashMap<>();

        for(int i=0; i<sz1; i++){
            st.add(wordlist[i]);
            
            tmp = wordlist[i].toLowerCase();
            if(!mp1.containsKey(tmp)) mp1.put(tmp, wordlist[i]);

            tmp = noVowelError(tmp);
            if(!mp2.containsKey(tmp)) mp2.put(tmp, wordlist[i]);
        }

        for(int i=0; i<sz2; i++){
            if(st.contains(queries[i])) ans[i] = queries[i];
            else{
                tmp = queries[i].toLowerCase();
                if(mp1.containsKey(tmp)) ans[i] = mp1.get(tmp);
                else if(mp2.containsKey(noVowelError(tmp))) ans[i] = mp2.get(noVowelError(tmp));
                else ans[i] = "";
            }
        }

        return ans;
    }

    private String noVowelError(String str){
        int sz = str.length();
        StringBuilder s = new StringBuilder(str);

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == 'e' || s.charAt(i) == 'i' 
            || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                s.setCharAt(i, 'a');
            }
        }

        return s.toString();
    }
}