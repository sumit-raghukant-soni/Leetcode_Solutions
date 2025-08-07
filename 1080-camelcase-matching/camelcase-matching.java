class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        boolean flg = false;
        int sz = queries.length;
        List<Boolean> ans = new ArrayList<>();

        int j=0, sz2 = pattern.length();
        for(String str : queries){
            flg = true;
            j=0;
            for(int i=0; i<str.length(); i++){
                if(j < sz2 && str.charAt(i) == pattern.charAt(j)) j++;
                else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    flg = false;
                } 
            }
            if(j < sz2) flg = false;
            ans.add(flg);
        }

        return ans;
    }
}