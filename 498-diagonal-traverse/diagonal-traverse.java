class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m*n];
        i = 0; j = 0; dir = 1;

        solve(mat, m, n, ans, 0);

        return ans;
    }

    int dir, i, j;
    private void solve(int[][] mat, int m, int n, int[] ans, int k){
        if(k >= (m*n)) return;
        
        while(i >= 0 && j >= 0 && i < m && j < n && k < m*n){ 
            ans[k++] = mat[i][j];
            if(dir == 1){
                i--; j++;
            }
            else{
                i++; j--;
            }
        }

        if(dir == 1){
            i++;
            if(j == n){
                j--; i++;
            }
        }
        else{
            j++; 
            if(i == m){
                i--; j++;
            }
        }
        dir = dir == 0 ? 1 : 0;
        // System.out.println("New indexes: " + i + " " + j + dir);
        if(k < m*n) solve(mat, m, n, ans, k);
    }
}