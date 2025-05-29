class Solution {
    public int clumsy(int n) {
        int sum = 0, sign = 1;
        int mul = 1;

        while(n > 0){
            if(n-1 > 0) mul = n * (n-1) * sign;
            else break;
            n-=2;
            if(n > 0) mul /= n--;
            if(n > 0) sum += n--;
            if(sign == 1) sign = -1;
            sum += mul;
        }

        if(n == 1) sum += n * sign;

        return sum;
    }
}