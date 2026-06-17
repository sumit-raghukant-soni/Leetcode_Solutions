class Solution {
    public char processStr(String s, long k) {
        int sz = s.length(), i;
        long sz2 = 0;
        char ch;

        for(i=0; i<sz; i++){
            ch = s.charAt(i);
            if(ch == '*') {
                if(sz2 > 0) sz2--;
            }
            else if(ch == '#') {
                sz2 *= 2;
            }
            else if(ch == '%') {
                // sz2 *= 2;
            }
            else {
                sz2++;
            }
        }

        if((k+1) > sz2) return '.';

        // System.out.println("Before " + st + " " + k + ":" + sz2);
        i = sz-1;
        while( i >= 0 ) {
            ch = s.charAt(i);
            if(ch == '*') {
                sz2++;
            }
            else if(ch == '#') {
                long h = (sz2+1)/2;
                if((k+1) > h) {
                    k -= sz2/2;
                }
                sz2 = h;
            }
            else if(ch == '%') {
                k = sz2 - k - 1;
            }
            else if(k == sz2-1) return ch;
            else if(ch >= 'a' && ch <= 'z') {
                sz2--;
            }
            i--;
            // System.out.println(k + ":" + sz2);
        }

        // System.out.println(st);

        return '.';
    }
}