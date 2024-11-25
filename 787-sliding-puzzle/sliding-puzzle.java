class Solution {
    public int ans;
    public void solve(HashMap<String, Integer> mp, int[][] board, int r, int c, int steps){
        if(check(board) == true){
            // System.out.println("Here");
            ans = Math.min(ans, steps);
            return;
        }
        if(mp.containsKey(Arrays.deepToString(board)) && mp.get(Arrays.deepToString(board)) <= steps) return;

        mp.put(Arrays.deepToString(board), steps);
        steps++;

        int dr[] = {0, -1, 0, 1}, dc[] = {1, 0, -1, 0};
        for(int i=0; i<4; i++){
            int nr = r + dr[i], nc = c + dc[i];
            if(nr >= 0 && nr < 2 && nc >= 0 && nc < 3){
                // for(int k=0; k<2; k++){
                //     for(int j=0; j<3; j++){
                //         System.out.print(board[k][j]);
                //     }
                //     System.out.println();
                // }
                // System.out.println(steps);
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
    public boolean check(int[][] board){
        if(board[0][0] != 1 || board[0][1] != 2 || board[0][2] != 3 || board[1][0] != 4 || board[1][1] != 5) return false;
        return true;
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