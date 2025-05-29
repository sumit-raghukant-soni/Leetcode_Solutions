class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m = edges1.length + 1, n = edges2.length + 1, max2 = 0, tmp;
        int ans[] = new int[m];
        int dp1[][] = new int[m][m], dp2[][] = new int[n][n];
        Map<Integer, List<Integer>> mp1 = new HashMap<>(), mp2 = new HashMap<>();

        for(int i=0; i<m; i++){
            mp1.put(i, new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            mp2.put(i, new ArrayList<>());
        }

        for(int i=0; i<m-1; i++){
            mp1.get(edges1[i][0]).add(edges1[i][1]);
            mp1.get(edges1[i][1]).add(edges1[i][0]);
        }

        for(int i=0; i<n-1; i++){
            mp2.get(edges2[i][0]).add(edges2[i][1]);
            mp2.get(edges2[i][1]).add(edges2[i][0]);
        }

        for(int i=0; i<m; i++){
            solve(i, m, dp1, mp1);
        }

        for(int i=0; i<n; i++){
            solve(i, n, dp2, mp2);
        }

        for(int i=0; i<n; i++){
            tmp = 0;
            for(int j=0; j<n; j++){
                // System.out.print(i + ":" + j + "<>" + dp2[i][j] + ", ");
                if(dp2[i][j] < k) tmp++;
            }
            // System.out.println();
            if(tmp > max2) max2 = tmp;
        }

        System.out.println(max2);
        System.out.println();

        for(int i=0; i<m; i++){
            tmp = 0;
            for(int j=0; j<m; j++){
                // System.out.print(i + ":" + j + "<>" + dp1[i][j] + ", ");
                if(dp1[i][j] <= k) tmp++;
            }
            // System.out.println();
            ans[i] = tmp + max2;
        }

        return ans;
    }

    private void solve(int i, int sz, int dp[][], Map<Integer, List<Integer>> mp){
        int dist = 1;
        int vis[] = new int[sz];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(null);

        while(!q.isEmpty()){
            if(q.peek() == null){
                q.poll();
                if(q.isEmpty()) break;
                q.add(null);
                dist++;
            }
            int curr = q.poll();

            for(int j : mp.get(curr)){
                if(vis[j] == 0 && i != j && dp[i][j] == 0){
                    vis[j] = 1;
                    dp[i][j] = dist;
                    q.add(j);
                }
            }
        }
    }
}