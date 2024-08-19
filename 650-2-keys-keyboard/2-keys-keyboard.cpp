class Solution {
public:
    int minSteps(int n) {
        int cnt = 0;

        for (int i = 2; i <= n; ++i) {
            while (n % i == 0) {
                cnt += i;
                n /= i;
            }
        }

        return cnt;
    }
};