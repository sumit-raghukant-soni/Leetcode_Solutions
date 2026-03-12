class Solution {
    public int maxSatisfied(int[] cust, int[] gpy, int mins) {
        int sz = cust.length, sum = 0, ans = 0, tmp = 0;

        for(int i=0; i<sz; i++) sum += cust[i] * (gpy[i] == 1 ? 0 : 1);

        for(int i=0; i<sz; i++){
            if (i >= mins) {
                ans = ans > (sum + tmp) ? ans : (sum + tmp);
                tmp -= cust[i - mins] * gpy[i - mins];
            }
            tmp += cust[i] * gpy[i];
        }

        ans = ans > (sum + tmp) ? ans : (sum + tmp); 

        return ans;
    }
}