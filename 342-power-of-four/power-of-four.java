class Solution {
    public boolean isPowerOfFour(int n) {
        int cnt = 0;

        while(n > 0){
            if((n&3) > 1) return false;
            cnt += (n&3);
            n >>= 2;
        }   

        return cnt == 1;
    }
}