class Solution {
    public int maxScore(String s) {
        int sz = s.length(), ans = 0;
        int zero = 0, one = 0;

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == '1') one++;
        }

        for(int i=0; i<sz-1; i++){
            if(s.charAt(i) == '0') zero++;
            else one--;
            ans = Math.max(ans, one+zero);
        }

        return ans;
    }
}