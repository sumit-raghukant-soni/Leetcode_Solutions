class Solution {
    public String makeFancyString(String s) {
        int sz = s.length(), sz2 = 0;
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<sz; i++){
            if(sz2 < 2 || (sz2 >= 2 && (ans.charAt(sz2-1) != s.charAt(i) || ans.charAt(sz2-2) != s.charAt(i)))){
                ans.append(s.charAt(i));
                sz2++;
            }
        }

        return ans.toString();
    }
}