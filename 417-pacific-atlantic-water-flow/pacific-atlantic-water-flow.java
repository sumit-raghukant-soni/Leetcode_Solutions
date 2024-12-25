class Solution {
    int dr[] = {0,1,0,-1}, dc[] = {1,0,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // System.out.println(i + ":" + j);
                if(flowInBoth(heights, i, j)){
                    // System.out.println("Yes");
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return ans;
    }

    private boolean flowInBoth(int[][] heights, int i, int j){
        Set<Pair<Integer, Integer>> vis1 = new HashSet<>(), vis2 = new HashSet<>();
        boolean a = flowInPacific(heights, i, j, vis1);
        // if(a) System.out.println("Pacific");
        boolean b = flowInAntartic(heights, i, j, vis2);
        // if(b) System.out.println("Antartic");
        return a && b;
    }

    private boolean flowInPacific(int[][] heights, int i, int j, Set<Pair<Integer, Integer>> vis){
        // System.out.println(i + ":p:" + j);
        if(i == 0 || j == 0) return true;

        vis.add(new Pair<>(i, j));
        boolean flows = false;
        for(int k=0; k<4; k++){
            int newi = i + dr[k], newj = j + dc[k];
            if(newi >= 0 && newj >= 0 && newi < heights.length && 
            newj < heights[0].length && heights[i][j] >= heights[newi][newj] && !vis.contains(new Pair(newi, newj))){
                flows = flowInPacific(heights, newi, newj, vis);
                if(flows) return true;
            }
        }

        return flows;
    }
    
    private boolean flowInAntartic(int[][] heights, int i, int j, Set<Pair<Integer, Integer>> vis){
        // System.out.println(i + ":a:" + j);
        if(i == heights.length-1 || j == heights[0].length-1) return true;

        vis.add(new Pair(i, j));
        boolean flows = false;
        for(int k=0; k<4; k++){
            int newi = i + dr[k], newj = j + dc[k];
            // System.out.println(newi + " " + newj);
            if(newi >= 0 && newj >= 0 && newi <= heights.length-1 && 
            newj <= heights[0].length-1 && heights[i][j] >= heights[newi][newj] && !vis.contains(new Pair(newi, newj))){
                flows = flowInAntartic(heights, newi, newj, vis);
                if(flows) return true;
            }
        }

        return flows;
    }
}