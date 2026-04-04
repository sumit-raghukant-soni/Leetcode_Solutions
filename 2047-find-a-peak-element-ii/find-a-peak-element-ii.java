class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        // if(n > m){
            return solveColWise(mat, m, n);
        // }

        // return new int[]{0,0};
    }

    private int[] solveColWise(int[][] mat, int m, int n) {
        int s = 0, e = n-1;

        while(s <= e){
            int currRow = 0;
            int mid = s + (e-s)/2;
            for(int i=0; i<m; i++){
                currRow = mat[currRow][mid] >= mat[i][mid] ? currRow : i;
            }
            boolean isLeftBigger = mid-1 >= 0 ? (mat[currRow][mid-1] > mat[currRow][mid]) : false;
            boolean isRightBigger = mid+1 < n ? (mat[currRow][mid+1] > mat[currRow][mid]) : false;
            if(!isLeftBigger && !isRightBigger){
                return new int[]{currRow, mid};
            }
            else if(isLeftBigger){
                e = mid - 1;
            }
            else s = mid + 1;
        }

        return new int[]{0,0};
    }
}