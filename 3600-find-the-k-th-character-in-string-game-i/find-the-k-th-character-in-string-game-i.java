class Solution {
    public char kthCharacter(int k) {
        int k2 = k;
        StringBuilder str = new StringBuilder("a");
        k2--;
        
        while(k2 > 0){
            if(str.length() == 1){
                str.append("b");
            }
            else{
                int sz = str.length()/2;
                String tmp = str.substring(sz);
                str.append(tmp);
                for(int i=0; i<sz; i++){
                    str.append( (char) ((tmp.charAt(i) - 'a' + 1)%26 + 'a') );
                }
                k2 -= sz*2;
            }
            // System.out.println(str);
        }

        return str.charAt(k-1);
    }
}