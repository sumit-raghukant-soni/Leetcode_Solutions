class Solution {
    private boolean flg = false;
    public boolean makesquare(int[] mat) {
        int sz = mat.length, total = 0;
        int arr[] = new int[4];

        for(int i=0; i<sz; i++) total += mat[i];

        if(total%4 != 0) return false;

        for(int i=0; i<4; i++) arr[i] = total/4;

        // Arrays.sort(mat);
        solve(mat, sz, arr, 0);

        return flg;
    }

    private void solve(int[] mat, int sz, int arr[], int ind) {
        if(ind == sz || flg){
            for(int i=0; i<4; i++){
                if(arr[i] != 0) return;
            }
            flg = true;
            return;
        }

        for(int i=0; i<4; i++){
            if(mat[ind] <= arr[i]){
                int j = i;
                while(--j >= 0 && arr[i] != arr[j]);
                if(j != -1) continue;
                arr[i] -= mat[ind];
                solve(mat, sz, arr, ind+1);
                arr[i] += mat[ind];
            }
        }
    }
}