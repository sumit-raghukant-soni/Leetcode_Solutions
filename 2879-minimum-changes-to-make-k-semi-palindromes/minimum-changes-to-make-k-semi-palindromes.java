class Solution {
    private int MAX = 100000;
    private int[][] costs = null, dp = null;
    public int minimumChanges(String s, int k) {
        int sz = s.length();
        costs = new int[sz][sz];
        dp = new int[sz][sz];

        for(int i=0; i<sz; i++) {
            Arrays.fill(costs[i], -1);
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(s, sz, k, 0);

        return ans;
    }

    private int solve(String s, int sz, int k, int i) {
        // System.out.println(k + " " + i + " sz " + sz);
        if(k == 0) return i == sz ? 0 : MAX;
        if(sz-i < (2*k)) return MAX;
        if(dp[i][k] != -1) return dp[i][k];

        int ans = MAX, tmp = 0;
        
        for(int j=i; j<sz; j++) {
            if(i != j) {
                // System.out.println(i + ":" + j + " " + k + " currCost " + currCost(s, i, j) + " <> " + solve(s, sz, k-1, j+1));
                tmp = currCost(s, i, j) + solve(s, sz, k-1, j+1);
                ans = ans < tmp ? ans : tmp;
            }
        } 

        // System.out.println("Final " + i + " : " + ans);
        return dp[i][k] = ans;
    }

    private int currCost(String str, int s, int e) {
        if(costs[s][e] != -1) return costs[s][e];
        int sz = e - s + 1, cnt = Integer.MAX_VALUE, tmp;
        
        for(int i=1; i<sz; i++) {
            if(sz%i != 0) continue;
            tmp = 0;
            for(int j=0; j<i; j++) {
                int count = (sz - 1 - j)/ i+1;
                for(int t=0; t<count/2; t++) {
                    // System.out.println("currCost " + s + " " + e + " " + i + ":" + j);
                    int left = s + j + t*i;
                    int right = s + j + (count - 1- t)*i;
                    if(str.charAt(left) != str.charAt(right)) tmp++;
                }
            }
            cnt = cnt < tmp ? cnt : tmp;
        }

        return costs[s][e] = cnt;
    }
}