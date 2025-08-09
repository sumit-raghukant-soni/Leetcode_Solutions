class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return Integer.bitCount(n) <= 1 && n%4 != 0;
        return n > 0 ? Integer.bitCount(n) <= 1 : false;
    }
}