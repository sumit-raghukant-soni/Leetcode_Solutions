class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, ans = 0;
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<row; i++){
            int curr = -1, val = 0;
            for(int j=0; j<col; j++){
                if(curr == -1){
                    curr = matrix[i][j];
                }
                else if(curr != matrix[i][j]){
                    curr = matrix[i][j];
                    val = val == 0 ? 1 : 0;
                }
                matrix[i][j] = val;
                // System.out.print(matrix[i][j] + " ");
            }
            // System.out.println();
            if(mp.containsKey(Arrays.toString(matrix[i])) == true){
                mp.put(Arrays.toString(matrix[i]), mp.get(Arrays.toString(matrix[i])) + 1);
            }
            else{
                mp.put(Arrays.toString(matrix[i]), 1);
            }
        }

        for (Map.Entry<String, Integer> entry : mp.entrySet()){
            ans = Math.max(ans, entry.getValue());
        }

        return ans;
    }
}