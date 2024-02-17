class Solution {
public:
    int mySqrt(int x) {
        if(x == 0) return 0;
        int ans = 1;

        for(int i=2; (1LL*i*i) <= x; i++) ans = i;

        return ans;
    }
};