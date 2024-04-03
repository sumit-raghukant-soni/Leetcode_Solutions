class Solution {
public:
    bool safe(vector<vector<char>>& board, int i, int j, int k){
        for(int ind=0; ind<9; ind++){
            if(board[ind][j] == char(k + '0')) return false;
            if(board[i][ind] == char(k + '0')) return false;
            if (board[3 * (i / 3) + ind / 3][3 * (j / 3) + ind % 3] == char(k + '0')) return false;
        }
        return true;
    }
    void solve(vector<vector<char>>& board, bool& solved, int i, int j){
        if(solved) return;
        if(j == 9) {i++, j = 0;}

        if(i == 9 && j == 0){
            solved = true; return;
        }

        if(board[i][j] == '.'){
            for(int k=1; k<=9; k++){
                if(safe(board, i, j, k)){
                    board[i][j] = char(k + '0');
                    solve(board, solved, i, j+1);
                }
                if(solved) break;
                else board[i][j] = '.';
            }
        }
        else solve(board, solved, i, j+1);
    }
    void solveSudoku(vector<vector<char>>& board) {
        bool solved = false;    

        solve(board, solved, 0, 0);
    }
};