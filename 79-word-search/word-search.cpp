class Solution {
public:
    bool find(vector<vector<char>>& board, int rows, int cols, string word, int sz, vector<vector<bool>>& vis, int i, int j, int ind){
        if(ind == sz) return true;

        vis[i][j] = true;
        int dr[4] = {0, 1, 0, -1}, dc[4] = {1, 0, -1, 0};
        bool ans = false;
        for(int k=0; k<4; k++){
            int row = dr[k] + i, col = dc[k] + j;
            if(row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word[ind] && !vis[row][col]){
                ans = find(board, rows, cols, word, sz, vis, row, col, ind+1);
            }
            if(ans) break;
        }
        vis[i][j] = false;

        return ans;
    }
    bool exist(vector<vector<char>>& board, string word) {
        int rows = board.size(), cols = board[0].size();
        int sz = word.length();
        vector<vector<bool>> vis(rows, vector<bool>(cols, false));

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                vis[i][j] = true;
                if(board[i][j] == word[0] && find(board, rows, cols, word, sz, vis, i, j, 1)) return true;
                vis[i][j] = false;
            }
        }

        return false;
    }
};