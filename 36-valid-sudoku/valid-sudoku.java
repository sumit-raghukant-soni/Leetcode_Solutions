class Solution {
    public boolean isValidSudoku(char[][] board) {
        int sz = 9;
        int vis[] = new int[9];

        for(int i=0; i<sz; i++){
            Arrays.fill(vis, 0);
            for(int j=0; j<sz; j++){
                if(board[i][j] != '.'){
                    if(vis[board[i][j] - '1'] == 1) return false;
                    vis[board[i][j] - '1'] = 1;
                }
            }
        }

        for(int i=0; i<sz; i++){
            Arrays.fill(vis, 0);
            for(int j=0; j<sz; j++){
                if(board[j][i] != '.'){
                    if(vis[board[j][i] - '1'] == 1) return false;
                    vis[board[j][i] - '1'] = 1;
                }
            }
        }

        for(int i=0; i<27; i+=3){
            int sc = i%9, sr = (i/9) * 3;
            Arrays.fill(vis, 0);
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    int r = j + sr, c = k + sc;
                    // System.out.println(r + " " + c);
                    if(board[r][c] != '.'){
                        if(vis[board[r][c] - '1'] == 1) return false;
                        vis[board[r][c] - '1'] = 1;
                    }
                }
            }
        }

        return true;
    }
}