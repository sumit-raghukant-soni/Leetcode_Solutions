class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int sz = queens.length;
        int dr[] = {0, 1, 0, -1, -1, -1, 1, 1}, dc[] = {1, 0, -1, 0, -1, 1, -1, 1}, grid[][] = new int[8][8];
        Integer[] tmp = null;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Integer[]> q = new LinkedList<>();

        for(int i=0; i<sz; i++){
            grid[queens[i][0]][queens[i][1]] = 2;
        }

        for(int i=0; i<8; i++){
            tmp = new Integer[4];
            tmp[0] = king[0]; tmp[1] = king[1];
            tmp[2] = dr[i]; tmp[3] = dc[i];
            q.add(tmp);
        }

        while(!q.isEmpty()){
            tmp = q.poll();

            int x = tmp[0], y = tmp[1], r = tmp[2], c = tmp[3];
            if(grid[x][y] == 2){
                ans.add(Arrays.asList(x, y));
                continue;
            }
            x += r;
            y += c;
            if(x < 8 && x >= 0 && y < 8 && y >= 0){
                tmp[0] = x;
                tmp[1] = y;
                q.add(tmp);
            }
        }

        return ans;
    }
}