class Solution {
    public String strWithout3a3b(int a, int b) {
        int i=0, sz1 = a, sz2 = b;
        StringBuilder str = new StringBuilder("");

        while(a > 0 && b > 0){
            a--; b--;
            str.append('a');
            str.append('b');
        }

        if(a > 0){
            a--;
            str.append('a');
        }

        while(a > 0 && i < (sz1+sz2)){
            if(i == str.length()) str.append('a');
            else str.insert(i, 'a');
            a--; i+=3;
        }

        if(b > 0){
            b--;
            str.insert(0, 'b');
        }
        
        i=0;
        while(b > 0 && i < (sz1+sz2)){
            if(i == str.length()) str.append('b');
            else str.insert(i, 'b');
            b--; i+=3;
        }

        return str.toString();
    }
}