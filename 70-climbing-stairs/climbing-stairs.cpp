class Solution {
public:
    int climbStairs(int n) {
        if(n <= 3) return n;
        int ans = 0, a = 2, b = 3;
        while(n > 3){
            ans = a + b;
            a = b;
            b = ans;
            n--;
        }
        return ans;
    }
};