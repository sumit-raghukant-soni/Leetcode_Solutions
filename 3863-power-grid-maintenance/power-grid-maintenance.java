class Solution {
    Map<Integer, TreeSet<Integer>> mp = new HashMap<>();
    Map<Integer, Integer> gmp = new HashMap<>();
    Map<Integer, TreeSet<Integer>> grp = new HashMap<>();
    int vis[] = null, k = 0, isActive[] = null;
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int m = connections.length, sz = queries.length;
        List<Integer> ans = new ArrayList<>();
        vis = new int[c+1];
        isActive = new int[c+1];

        for(int i=1; i<=c; i++){
            mp.put(i, new TreeSet<>());
            isActive[i] = 1;
        }

        for(int i=0; i<m; i++){
            mp.get(connections[i][0]).add(connections[i][1]);
            mp.get(connections[i][1]).add(connections[i][0]);
        }

        for(int i=1; i<=c; i++){
            if(!gmp.containsKey(i)){
                grp.put(k, new TreeSet<>());
                solve(i, k++);
            }
        }

        for(int i=0; i<sz; i++){
            if(queries[i][0] == 1){
                if(isActive[queries[i][1]] == 0){
                    // System.out.println( grp.get(gmp.get(queries[i][1])) );
                    ans.add(getStation(gmp.get(queries[i][1])));
                }
                else ans.add(queries[i][1]);
            }
            else{
                grp.get(gmp.get(queries[i][1])).remove(queries[i][1]);
                isActive[queries[i][1]] =  0;
            }
        }

        int[] finalAns = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            finalAns[i] = ans.get(i);
        }

        return finalAns;        
    }

    private int getStation(int i){
        // System.out.println("New");
        for(int j : grp.get(i)){
            // System.out.println(i + " " + j);
            if(isActive[j] == 1) return j;
        }

        return -1;
    }

    private void solve(int i, int k){
        gmp.put(i, k);
        grp.get(k).add(i);
        vis[i] = 1;

        for(int j : mp.get(i)){
            if(vis[j] == 0){
                solve(j, k);
            }
        }
    }
}