class Solution {
    public int kthGrammar(int n, int k) {
        int flg = 1;

        while(n >= 1){
            if(k > Math.pow(2, n-1)){
                flg *= -1;
                k -= Math.pow(2, n-1);
            }
            n--;
        }

        return flg == 1 ? 0 : 1;
    }
}