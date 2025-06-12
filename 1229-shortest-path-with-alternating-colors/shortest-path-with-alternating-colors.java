class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int sz1 = redEdges.length, sz2 = blueEdges.length;
        int adj1[][] = new int[n][n], ans[] = new int[n];
        int adj2[][] = new int[n][n];

        for(int i=0; i<sz1; i++){
            adj1[redEdges[i][0]][redEdges[i][1]] = 1;
        }

        for(int i=0; i<sz2; i++){
            adj2[blueEdges[i][0]][blueEdges[i][1]] = 2;
        }

        for(int i=0; i<n; i++){
            ans[i] = solve(adj1, adj2, n, i);
        }

        return ans;
    }

    public int solve(int[][] adj1, int[][] adj2, int n, int dest){
        int cnt = 0, vis[][] = new int[n][3];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        q.add(null);
        vis[0][0] = 1;

        while(!q.isEmpty()){
            if(q.peek() == null){
                q.poll();
                if(q.isEmpty()) break;
                q.add(null);
                cnt++;
            }
            int curr = q.peek().getKey(), c = q.peek().getValue();
            q.poll();
            if(curr == dest) return cnt;
            
            for(int i=0; i<n; i++){
                if(adj1[curr][i] != 0 && adj1[curr][i] != c && vis[i][adj1[curr][i]] == 0){
                    vis[i][adj1[curr][i]] = 1;
                    q.add(new Pair(i, adj1[curr][i]));
                }
                if(adj2[curr][i] != 0 && adj2[curr][i] != c && vis[i][adj2[curr][i]] == 0){
                    vis[i][adj2[curr][i]] = 1;
                    q.add(new Pair(i, adj2[curr][i]));
                }
            }
        }

        return -1;
    }
}