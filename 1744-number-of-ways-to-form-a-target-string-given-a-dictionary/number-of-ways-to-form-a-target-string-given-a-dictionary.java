class Solution {
    public int numWays(String[] words, String target) {
        int sz = words.length, mxSz = 0;
        Map<Pair<Integer, Character>, Long> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            mxSz = Math.max(words[i].length(), mxSz);
            for(int j=0; j<words[i].length(); j++){
                Pair<Integer, Character> p = new Pair(j, words[i].charAt(j));
                mp.put(p, mp.getOrDefault(p, new Long(0)) + 1);
            }
        }

        long dp[][] = new long[target.length()+1][mxSz+1];
        for(int i=0; i<=target.length(); i++){
            for(int j=0; j<=mxSz; j++){
                dp[i][j] = -1;
            }
        }
        long ans = solve(dp, target, target.length(), mxSz, mp, 0, 0);

        if(dp[0][0] == -1) return 0;
        return (int) (dp[0][0]%(1000000007));
    }

    private long solve(long[][] dp, String target, int sz, int mxSz, Map<Pair<Integer, Character>, Long> mp, int i, int j){
        if(i == sz){
            return 1;
        }
        if(j >= mxSz-(sz-i-1)) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        long take = 0, notTake = solve(dp, target, sz, mxSz, mp, i, j+1);

        Pair<Integer, Character> p = new Pair(j, target.charAt(i));
        if(mp.containsKey(p)){
            take = new Long(mp.get(p)) * solve(dp, target, sz, mxSz, mp, i+1, j+1);
        }

        // System.out.println(i + ":" + j + " " + take + " " + notTake);
        return dp[i][j] = (take + notTake)%(1000000007);
    }
}