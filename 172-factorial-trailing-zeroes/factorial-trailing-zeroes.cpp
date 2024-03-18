class Solution {
public:
    int trailingZeroes(int n) {
        if(n < 5) return 0;

        int digit = 0;
        for(int i=5; i<=n; i*=5){
            digit += n/i;
        }

        return digit;
    }
};