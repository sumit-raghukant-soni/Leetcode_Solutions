class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double arr[][] = new double[query_row+1][query_row+1];

        arr[0][0] = poured;
        for(int i=1; i<=query_row; i++){
            for(int j=0; j<=i; j++){
                double left = 0, right = 0;
                if(j-1 >= 0) left = arr[i-1][j-1] > 1 ? (arr[i-1][j-1] - 1)/2 : 0;
                right = arr[i-1][j] > 1 ? (arr[i-1][j] - 1)/2 : 0;
                arr[i][j] = left + right;
            }
        }


        return arr[query_row][query_glass] > 1 ? 1 : arr[query_row][query_glass];
    }
}