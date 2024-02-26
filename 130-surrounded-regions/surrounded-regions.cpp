class Solution {
public:
    void solveMini(vector<vector<char>>& board, int row, int col, vector<vector<int>>& vis, int i, int j){
        if(i < 0 || i == row || j < 0 || j == col || vis[i][j] != -1 || board[i][j] == 'X') return;

        vis[i][j]++;
        int dr[4] = {0, 1, 0, -1}, dc[4] = {1, 0, -1, 0};
        for(int k=0; k<4; k++){
            int r = i+dr[k], c = j+dc[k];
            solveMini(board, row, col, vis, r, c);
        }
    }
    void solve(vector<vector<char>>& board) {
        int row = board.size(), col = board[0].size();
        vector<vector<int>> vis(row, vector<int>(col, -1));

        for(int i=0; i<row; i++){
            if(board[i][0] == 'O' && vis[i][0] == -1) solveMini(board, row, col, vis, i, 0);
            if(board[i][col-1] == 'O' && vis[i][col-1]) solveMini(board, row, col, vis, i, col-1);
        }

        for(int j=0; j<col; j++){
            if(board[0][j] == 'O' && vis[0][j] == -1) solveMini(board, row, col, vis, 0, j);
            if(board[row-1][j] == 'O' && vis[row-1][j] == -1) solveMini(board, row, col, vis, row-1, j);
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O' && vis[i][j] == -1) board[i][j] = 'X';
            }
        }
    }
};