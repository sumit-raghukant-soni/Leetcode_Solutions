class Solution {
    private int dp[][] = null;
    public boolean isMatch(String s, String p) {
        int sz1 = s.length(), sz2 = p.length();

        dp = new int[sz1][sz2];

        for(int i=0; i<sz1; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(s, p, sz1, sz2, 0, 0) == 1;
    }
    private int solve(String s, String p, int sz1, int sz2, int i, int j) {
        // System.out.println("first " + i + ":" + j);
        if(i == sz1 && j == sz2) return 1;
        if(i == sz1) {
            int k = j;
            for(; k<sz2; k++){
                if(k+1 < sz2 && p.charAt(k+1) == '*') k++;
                else break;
            }
            // System.out.println("K out " + (k == sz2));
            return k == sz2 ? 1 : 0;
        }
        if(j == sz2) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        // System.out.println(s.charAt(i) + " " + p.charAt(j));

        int c = 0;
        if(j+1 < sz2 && p.charAt(j+1) == '*') {
            char ch = p.charAt(j);
            for(int k=i; k<sz1; k++){
                // System.out.println("* " + s.charAt(k) + " vs " + ch);
                if(ch != '.' && s.charAt(k) != ch) break;
                else {
                    c = Math.max(c, solve(s, p, sz1, sz2, k+1, j+2));
                }
            }
            c = Math.max(c, solve(s, p, sz1, sz2, i, j+2));
        }
        else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ) c = solve(s, p, sz1, sz2, i+1, j+1);
        else c = 0;

        // System.out.println("Return from " + s.charAt(i) + " " + p.charAt(j) + " " + c);
        return dp[i][j] = c;
    }
}