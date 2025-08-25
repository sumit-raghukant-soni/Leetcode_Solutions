class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, ind = 0, flg = 0;
        int ans[] = new int[m*n];
        List<Integer> lst = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            int k = 0;
            lst.clear();
            for(int j=i; j>=0 && k < m; j--){
                if(flg == 1) lst.add(mat[k++][j]);
                else lst.add(0, mat[k++][j]);
            }
            flg = flg == 1 ? 0 : 1;
            for(int val : lst){
                ans[ind++] = val;
            }
        }

        for(int i=1; i<m; i++){
            int k = n-1;
            lst.clear();
            for(int j=i; j<m && k >= 0; j++){
                if(flg == 1) lst.add(mat[j][k--]);
                else lst.add(0, mat[j][k--]);
            }
            flg = flg == 1 ? 0 : 1;
            // System.out.println(lst);
            for(int val : lst){
                ans[ind++] = val;
            }
        }

        return ans;
    }
}