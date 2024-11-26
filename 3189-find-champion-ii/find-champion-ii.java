class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] degree = new int[n];

        for(int i=0; i<edges.length; i++){
            degree[edges[i][1]]++;
        }

        int cnt = 0, ans = 0;
        for(int i=0; i<n; i++){
            if(degree[i] == 0){
                cnt++; ans = i;
            }
        }

        return (cnt > 1 || cnt == 0) ? -1 : ans;
    }
}