class Solution {
    int ones[] = null, zeros[] = null;
    Map<Integer, Integer> mp = new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        int sz = strs.length;
        ones = new int[sz];
        zeros = new int[sz];

        for(int i=0; i<sz; i++){
            int one = 0, zero = 0;
            for(int j=0; j<strs[i].length(); j++){
                char ch = strs[i].charAt(j);
                if(ch == '1') one++;
                else zero++;
            }
            ones[i] = one;
            zeros[i] = zero;
            // System.out.println(one + ":" + zero);
        }

        return solve(0, sz, m, n);
    }

    private int solve(int i, int sz, int m, int n){
        if(i >= sz) return 0;
        int key = (i * 100000000) + (m * 100000) + n;
        if(mp.containsKey(key)) return mp.get(key);

        int take = 0, notTake = solve(i+1, sz, m, n);
        if(n >= ones[i] && m >= zeros[i]){
            take = 1 + solve(i+1, sz, m - zeros[i], n - ones[i]);
        }

        mp.put(key, take > notTake ? take : notTake);
        return take > notTake ? take : notTake;
    }
}
