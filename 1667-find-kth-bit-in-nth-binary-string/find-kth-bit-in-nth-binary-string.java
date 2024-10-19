class Solution {
    public String customReverse(String s){
        int sz = s.length();
        StringBuffer str = new StringBuffer(s);
        char a, b;

        for(int i=0; i<sz; i++){
            a = str.charAt(i);
            if(a == '0'){
                str.setCharAt(i, '1');
            }
            else{
                str.setCharAt(i, '0');
            }
        }

        return str.reverse().toString();
    }
    public char findKthBit(int n, int k) {
        String ans = "0";

        for(int i=0; i<n; i++){
            ans = ans + "1" + customReverse(ans);
        }

        return ans.charAt(k-1);
    }
}