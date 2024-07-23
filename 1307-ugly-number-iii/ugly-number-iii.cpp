class Solution {
public:
    int nthUglyNumber(int n, int A, int B, int C) {
        long s = 1, e = 1LL*2*INT_MAX;
        long a = long(A), b = long(B), c = long(C);
        long ab = (a*b / __gcd(a,b)), ac = (a*c / __gcd(a,c)), bc = (c*b / __gcd(c,b)), abc = (a*bc / __gcd(a,bc));

        while(s < e){
            long long mid = s + (e-s)/2;
            long long num = (mid/a) + (mid/b) + (mid/c) - (mid/ab) - (mid/ac) - (mid/bc) + (mid/abc);
            
            if(num < n){
                s = mid + 1;
            }
            else e = mid;
        }

        return s;
    }
};