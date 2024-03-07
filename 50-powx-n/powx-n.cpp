class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1 || x == 1) return x;

        int sign = 1;
        if(n < 0) sign = -1;
        double tmp = myPow(x, abs(n)/2), val = (n&1) ? tmp*tmp*x : tmp*tmp;
        
        if(sign == -1) return 1/val;
        return val;
    }
};