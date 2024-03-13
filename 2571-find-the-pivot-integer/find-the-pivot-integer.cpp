class Solution {
public:
    int pivotInteger(int n) {
        int sum = (n * (n+1))/2, sum2 = 0;

        for(int i=1; i<=n; i++){
            sum2 += i;
            if(sum == sum2) return i;
            sum -= i;
        }

        return -1;
    }
};