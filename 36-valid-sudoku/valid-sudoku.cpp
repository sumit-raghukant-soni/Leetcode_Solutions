class Solution {
public:
    bool valid(vector<vector<char>>& board, int row, int col){
        for(int i=0; i<9; i++){
            if(row != i && col != i && (board[i][col] == board[row][col] || board[row][i] == board[row][col])) return false;
        }
        int x = row < 3 ? 0 : (row < 6 ? 3 : 6),y = col < 3 ? 0 : (col < 6 ? 3 : 6);
        // cout << row << " " << col << " = " << x << " " << y << endl;
        for(int i=0; i<9; i++){
            int r = x+(i/3), c = y+(i%3);
            if(r != row && c != col && board[r][c] == board[row][col]) return false;
        }

        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && !valid(board, i, j)){
                    // cout << board[i][j] << endl;
                    return false;
                } 
            }
        }

        return true;
    }
};