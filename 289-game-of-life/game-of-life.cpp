class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        vector<vector<int>> tmp = board;
        int row = board.size(), col = board[0].size(), count = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                count = 0;
                if(j-1 >= 0){
                    if(tmp[i][j-1] == 1) count++;
                }
                if(j+1 < col){
                    if(tmp[i][j+1] == 1) count++;
                }
                if(i-1 >= 0){
                    if(tmp[i-1][j] == 1) count++;
                    if(j-1 >= 0 && tmp[i-1][j-1] == 1) count++;
                    if(j+1 < col && tmp[i-1][j+1] == 1) count++;
                }
                if(i+1 < row){
                    if(tmp[i+1][j] == 1) count++;
                    if(j-1 >= 0 && tmp[i+1][j-1] == 1) count++;
                    if(j+1 < col && tmp[i+1][j+1] == 1) count++;
                }
                if(board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = 0;
                else if(board[i][j] == 0 && count == 3) board[i][j] = 1;
            }
        }
    }
};