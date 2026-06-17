class Solution {
    public String processStr(String s) {
        int sz = s.length(), sz2 = 0;
        char ch;
        StringBuilder str = new StringBuilder("");

        for(int i=0; i<sz; i++){
            ch = s.charAt(i);
            if(ch == '*') {
                if(sz2 == 0) continue;
                sz2--;
                str.deleteCharAt(sz2);
            }
            else if(ch == '#') {
                str.append(str.toString());
                sz2 += sz2;
            }
            else if(ch == '%') {
                str.reverse();
            }
            else {
                sz2++;
                str.append(ch);
            }
        }

        return str.toString();
    }
}