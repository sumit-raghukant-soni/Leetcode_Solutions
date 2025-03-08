class Solution {
    public int findNthDigit(int n) {
        long start = 1, end = 9, k = 1;

        while(n > k*end){
            n -= k*end;
            end *= 10;
            start *= 10;
            k++;
        }

        long num = start + (n-1)/k;

        String ans = String.valueOf(num);

        return ans.charAt( (int)((n-1)%k) ) - '0';
    }
}