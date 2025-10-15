class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sz = colsum.length;
        int[][] arr = new int[2][sz];
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.fill(arr[0], -1);
        Arrays.fill(arr[1], -1);

        for(int i=0; i<sz; i++){
            if(colsum[i] == 2 && upper >= 1 && lower >= 1){
                arr[0][i] = arr[1][i] = 1;
                upper--; lower--;
                colsum[i] = 0;
            }
            else if(colsum[i] == 2) return ans;
        }

        for(int i=0; i<sz; i++){
            if(colsum[i] == 1){
                if(upper > 0){
                    arr[0][i] = 1; upper--;
                    arr[1][i] = 0;
                }
                else if(lower > 0){
                    arr[1][i] = 1; lower--;
                    arr[0][i] = 0;
                }
                else return ans;
            }
            else{
                arr[0][i] = arr[0][i] == -1 ? 0 : arr[0][i];
                arr[1][i] = arr[1][i] == -1 ? 0 : arr[1][i];
            }
        }

        if(upper > 0 || lower > 0) return ans;

        for(int i=0; i<2; i++){
            ans.add(new ArrayList<>());
            for(int j=0; j<sz; j++){
                ans.get(i).add(arr[i][j]);
            }
        }

        return ans;
    }
}