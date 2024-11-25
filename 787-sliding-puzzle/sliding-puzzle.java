class Solution {
    public int ans;
    public void solve(HashMap<String, Integer> mp, int[][] board, int r, int c, int steps){
        String tmp = Arrays.deepToString(board);
        if(tmp.equals("[[1, 2, 3], [4, 5, 0]]")){
            // System.out.println("Here");
            ans = Math.min(ans, steps);
            return;
        }
        // System.out.println(tmp);
        if(mp.containsKey(tmp) && mp.get(tmp) <= steps) return;

        mp.put(tmp, steps);
        steps++;

        int dr[] = {0, -1, 0, 1}, dc[] = {1, 0, -1, 0};
        for(int i=0; i<4; i++){
            int nr = r + dr[i], nc = c + dc[i];
            if(nr >= 0 && nr < 2 && nc >= 0 && nc < 3){
                swap(board, r, c, nr, nc);
                solve(mp, board, nr, nc, steps);
                swap(board, r, c, nr, nc);
            }
        }

    }
    public void swap(int[][] board, int r, int c, int nr, int nc){
        int tmp = board[r][c];
        board[r][c] = board[nr][nc];
        board[nr][nc] = tmp;
    }
    public int slidingPuzzle(int[][] board) {
        int r = 0, c = 0;
        ans = Integer.MAX_VALUE;
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 0){
                    r = i; c = j; break;
                }
            }
        }

        solve(mp, board, r, c, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}