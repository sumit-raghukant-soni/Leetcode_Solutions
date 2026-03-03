class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");

        for(int i=1; i<n; i++){
            String str = sb.toString();
            sb.append('1');
            for(int j=str.length()-1; j>=0; j--){
                if(str.charAt(j) == '1') sb.append('0');
                else sb.append('1');
            }
        }
        // System.out.println(sb.toString());
        return sb.toString().charAt(k-1);
    }
}