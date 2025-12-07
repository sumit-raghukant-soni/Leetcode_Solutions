class Solution {
    boolean flg = false;
    int m, n;
    Map<Integer, Pair<Integer, Integer>> dir = new HashMap<>();
    int vis[][];
    public boolean hasValidPath(int[][] grid) {
        m = grid.length; n = grid[0].length;
        vis = new int[m][n];
        solve(grid, 0, 0);

        return flg;
    }

    private void solve(int grid[][], int i, int j){
        if(flg) return;
        if(i == m-1 && j == n-1){
            flg = true;
            return;
        }
        vis[i][j] = 1;

        switch(grid[i][j]){
            case 1:
            left(grid, i, j);
            right(grid, i, j);
            case 2:
            up(grid, i, j);
            down(grid, i, j);
            break;
            case 3:
            left(grid, i, j);
            down(grid, i, j);
            break;
            case 4:
            right(grid, i, j);
            down(grid, i, j);
            break;
            case 5:
            left(grid, i, j);
            up(grid, i, j);
            break;
            case 6:
            up(grid, i, j);
            right(grid, i, j);
            break;
        }
    }

    private void left(int grid[][], int i, int j){
        if(j-1 >= 0 && vis[i][j-1] == 0 && (grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 6)){
            solve(grid, i, j-1);
        }
    }

    private void right(int grid[][], int i, int j){
        if(j+1 < n && vis[i][j+1] == 0 && (grid[i][j+1] == 1 || grid[i][j+1] == 3 || grid[i][j+1] == 5)){
            solve(grid, i, j+1);
        }
    }
    private void up(int grid[][], int i, int j){
        if(i-1 >= 0 && vis[i-1][j] == 0 && (grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4)){
            solve(grid, i-1, j);
        }
    }

    private void down(int grid[][], int i, int j){
        if(i+1 < m && vis[i+1][j] == 0 && (grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6)){
            solve(grid, i+1, j);
        }
    }
}