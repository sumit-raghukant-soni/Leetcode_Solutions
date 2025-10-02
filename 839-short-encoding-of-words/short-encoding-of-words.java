class Solution {
    public int minimumLengthEncoding(String[] words) {
        int sz  = words.length, ans = 0;
        boolean flg[] = new boolean[sz];
        
        Set<String> st = new HashSet<>();
        for(String str : words) st.add(str);

        sz = st.size();
        String[] words2 = new String[sz];
        st.toArray(words2);

        for(int i=0; i<sz; i++){
            // System.out.println(words2[i]);
            int sz2 = words2[i].length();
            for(int j=0; j<sz; j++){
                if(i == j) continue;
                // System.out.println(words2[i] + " <> " + words2[j] + " <> " + (words2[j].length() - words2[j].lastIndexOf(words2[i])) + " " + sz2);           
                int ind = words2[j].lastIndexOf(words2[i]);
                if(ind != -1 && words2[j].length() - ind == sz2){
                    // System.out.println("Here " + words2[i]);
                    flg[i] = true;
                    break;
                }
            }
        }

        for(int i=0; i<sz; i++){
            if(!flg[i]){
                ans += words2[i].length() + 1;
            }
        }

        return ans;
    }
}