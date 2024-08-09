class Solution {
public:
    class Node{
        public:
        int row, col, dia;
        Node(){
            row = col = dia = 0;
        }
    };
    bool check(vector<vector<int>>& grid, vector<vector<Node>>& dp, int& i, int& j){
        int val = dp[i][j].col;
        // cout << "Here " << dp[i][j-1].col << dp[i][j-2].col << dp[i-1][j].row << dp[i-2][j].row << endl;
        if(dp[i][j-1].col != val || dp[i][j-2].col != val || dp[i-1][j].row != val || dp[i-2][j].row != val) return false;
        int diagonal = i-2+j, diagonalValue = 0;
        vector<int> digits(9, 0);
        // cout << "Here" << endl;
        for(int k=i-2; k<=i; k++){
            for(int l=j-2; l<=j; l++){
                if(k+l == diagonal) diagonalValue+= grid[k][l];
                if(grid[k][l] > 0 && grid[k][l] < 10) digits[grid[k][l]-1]++;
                else return false;
            }
        }
        for(int i : digits) if(i != 1) return false;

        // cout << i << ":" << j << " " << diagonalValue << endl;
        return diagonalValue == val;
    }
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size(), ans = 0;
        vector<vector<Node>> dp(m, vector<Node>(n, Node()));

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j].row = (j-1 >= 0 ? dp[i][j-1].row + grid[i][j] : grid[i][j]);
                dp[i][j].col = (i-1 >= 0 ? dp[i-1][j].col + grid[i][j] : grid[i][j]);
                dp[i][j].dia = (j-1 >= 0 && i-1 >= 0 ? dp[i-1][j-1].dia + grid[i][j] : grid[i][j]);

                if(j >= 3) dp[i][j].row -= grid[i][j-3];
                if(i >= 3) dp[i][j].col -= grid[i-3][j];
                if(i >= 3 && j >= 3) dp[i][j].dia -= grid[i-3][j-3];
            }
        }

        for(int i=2; i<m; i++){
            for(int j=2; j<n; j++){
                // cout << dp[i][j].row << ":" << dp[i][j].col << ":" << dp[i][j].dia << " ";
                if(dp[i][j].row == dp[i][j].col && dp[i][j].col == dp[i][j].dia && check(grid, dp, i, j)) ans++;
            }
            // cout << endl;
        }

        return ans;
    }
};