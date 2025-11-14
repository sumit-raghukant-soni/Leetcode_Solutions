class Solution {
    public List<String> printVertically(String s) {
        int sz = s.length();
        List<String> ans = new ArrayList<>();
        int maxSz = 0;

        for(int i=0; i<sz; i++){
            // System.out.println(maxSz + " " + i);
            for(int j=0; i<sz && s.charAt(i) != ' '; j++, i++){
                if(j >= ans.size()) ans.add("");
                for(int k=ans.get(j).length(); k<maxSz-1; k++){
                    ans.set(j, ans.get(j) + " ");
                }
                ans.set(j, ans.get(j) + s.charAt(i));
                maxSz = maxSz > ans.get(j).length() ? maxSz : ans.get(j).length();
            }
        }

        return ans;
    }
}