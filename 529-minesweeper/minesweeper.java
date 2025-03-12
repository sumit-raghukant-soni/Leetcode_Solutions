class Solution {
    private int dr[] = {0, -1, 0, 1, 1, -1, 1, -1}, dc[] = {1, 0, -1, 0, 1, 1, -1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int sz = click.length, x, y;

        x = click[0]; y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }
        else if(board[x][y] == 'E'){
            updateBoard(board, m, n, x, y);
        }

        return board;
    }

    private void updateBoard(char[][] board, int m, int n, int x, int y){
        if(x < 0 || y < 0 || x >= m || y >= n) return;

        int adjMines = getAdjMines(board, m, n, x, y);
        if(adjMines > 0){
            board[x][y] = (char) (adjMines + '0');
            return;
        }
        else board[x][y] = 'B';

        for(int i=0; i<8; i++){
            int newx = x + dr[i], newy = y + dc[i];
            if(newx >= 0 && newy >= 0 && newx < m && newy < n && board[newx][newy] == 'E'){
                updateBoard(board, m, n, newx, newy);
            }
        }
    }

    private int getAdjMines(char[][] board, int m, int n, int x, int y){
        int ans = 0;

        for(int i=0; i<8; i++){
            int newx = x + dr[i], newy = y + dc[i];
            if(newx >= 0 && newy >= 0 && newx < m && newy < n && board[newx][newy] == 'M') ans++; 
        }

        return ans;
    }
}