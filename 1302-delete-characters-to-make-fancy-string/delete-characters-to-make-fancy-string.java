class Solution {
    public String makeFancyString(String s) {
        int sz = s.length();
        StringBuilder ans = new StringBuilder("");

        for(int i=0; i<sz; i++){
            if(ans.length() >= 2){
                int len = ans.length();
                if(!(ans.charAt(len-1) == s.charAt(i) && ans.charAt(len-2) == s.charAt(i))) ans.append(s.charAt(i));
            }
            else ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}