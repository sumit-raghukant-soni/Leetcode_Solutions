class Solution {
    public String removeOuterParentheses(String s) {
        int sz = s.length(), j = 0, cnt = 0;
        char ch;
        StringBuilder str = new StringBuilder("");

        for(int i=0; i<sz; i++) {
            ch = s.charAt(i);
            if(ch == '(') {
                cnt++;
            }
            else cnt--;
            // System.out.println(i + " " + cnt);
            if(cnt == 0) {
                // System.out.println((j+1) + " " + (i-j));
                str.append(s.substring(j+1, j + (i-j) ));
                j = i+1;
            }
        }

        return str.toString();
    }
}