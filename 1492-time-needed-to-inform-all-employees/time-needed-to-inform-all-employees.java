class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        Set<Integer> mgs = new HashSet<>();
        int dp[] = new int[n];

        for(int i=0; i<n; i++) mgs.add(manager[i]);

        for(int i=0; i<n; i++){
            if(!mgs.contains(i)){
                q.add(new Pair(i, 0));
            }
        }

        while(!q.isEmpty()){
            int curr = q.peek().getKey(), time = q.poll().getValue();

            if(curr == headID){
                dp[headID] = time > dp[headID] ? time : dp[headID];
                continue;
            }

            dp[curr] = dp[curr] > time ? dp[curr] : time;
            time += informTime[manager[curr]];
            if(dp[manager[curr]] < time){
                q.add(new Pair(manager[curr], time));
            }
        }
        
        return dp[headID];
    }
}