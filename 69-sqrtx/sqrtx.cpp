class Solution {
public:
    int mySqrt(int x) {
        if(x == 0) return 0;
        int ans = 1;

        int s = 1, e = x/2, mid;
        while(s <= e){
            mid = s + (e-s)/2;
            if(1LL*mid*mid <= x) ans = mid;
            if(1LL*mid*mid > x) e = mid-1;
            else s = mid+1;
        }

        return ans;
    }
};