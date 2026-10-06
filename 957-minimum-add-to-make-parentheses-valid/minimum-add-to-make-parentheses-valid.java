class Solution {
    public int minAddToMakeValid(String s) {
        int sz = s.length(), cnt = 0, p = 0;
        char ch;

        for(int i=0; i<sz; i++) {
            ch = s.charAt(i);
            if(ch == '(') cnt++;
            else {
                if(cnt <= 0) p++;
                else cnt--;
            }
        }

        return p + cnt;
    }
}