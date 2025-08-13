class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;

        long tmp = 1;
        while(tmp < Integer.MAX_VALUE){
            if(n == tmp) return true;
            tmp *= 3;
        }

        return false;
    }
}