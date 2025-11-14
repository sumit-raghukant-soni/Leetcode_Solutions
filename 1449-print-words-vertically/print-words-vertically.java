class Solution {
    public List<String> printVertically(String s) {
        int sz = s.length();
        List<StringBuilder> ans = new ArrayList<>();
        List<String> finalAns = new ArrayList<>();
        int maxSz = 0;

        for(int i=0; i<sz; i++){
            int sz2 = 0;
            for(int j=0; i<sz && s.charAt(i) != ' '; j++, i++){
                if(j >= ans.size()) ans.add(new StringBuilder(""));
                sz2 = ans.get(j).length();
                for(int k=sz2; k<maxSz-1; k++){
                    sz2++;
                    ans.get(j).append(" ");
                }
                sz2++;
                ans.get(j).append(s.charAt(i));
                maxSz = maxSz > sz2 ? maxSz : sz2;
            }
        }

        for(int i=0; i<ans.size(); i++){
            finalAns.add(ans.get(i).toString());
        }

        return finalAns;
    }
}