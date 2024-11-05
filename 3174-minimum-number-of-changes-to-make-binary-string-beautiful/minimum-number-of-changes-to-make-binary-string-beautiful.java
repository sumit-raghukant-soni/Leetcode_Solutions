class Solution {
    public int minChanges(String s) {
        int sz = s.length(), ans = 0;

        for(int i=0; i<sz-1; i+=2){
            if(s.charAt(i) != s.charAt(i+1)) ans++;
        }

        return ans;
    }
}