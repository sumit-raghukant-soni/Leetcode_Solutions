class Solution {
    private int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        int n2 = n, k = 0;
        int sz = queries.length, ans[] = new int[sz], pSum[] = null;
        List<Integer> lst = new ArrayList<>();

        while(n2 > 0){
            if((n2&1) == 1) lst.add(k);
            k++;
            n2 >>= 1;
        }

        pSum = new int[lst.size()];

        for(int i=0; i<lst.size(); i++){
            pSum[i] = lst.get(i);
            if(i > 0) pSum[i] += pSum[i-1];
        }

        for(int i=0; i<sz; i++){
            int pow = pSum[queries[i][1]];
            if(queries[i][0] > 0) pow -= pSum[queries[i][0] - 1];

            ans[i] = calc(pow);
        }

        return ans;
    }

    private int calc(int pow){
        long res = 1, a = 2;

        a = a % MOD;
        while(pow > 0){
            if((pow&1) == 1){
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            pow /= 2;
        }

        return (int) res;
    }
}