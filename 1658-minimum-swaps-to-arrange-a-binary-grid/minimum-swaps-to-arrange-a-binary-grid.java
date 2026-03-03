class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0;
        int fq[] = new int[n], used[] = new int[n];

        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                if(grid[i][j] == 1) break;
                fq[i]++;
            }
        }
        
        Arrays.fill(used, -1);
        for(int i=n-1; i>=1; i--){
            boolean flg = false;
            for(int j=n-(i+1); j<n; j++){
                if(fq[j] >= i){
                    // used[j] = (n-1) - i;
                    for(int k=j; k>n-(i+1); k--){
                        int tmp = fq[k-1];
                        fq[k-1] = fq[k];
                        fq[k] = tmp;
                        ans++;
                    }
                    flg = true;
                    break;
                }
            }
            // for(int j=0; j<n; j++){
            //     System.out.print(fq[j] + ", ");
            // }
            // System.out.println();
            if(!flg) return -1;
        }

        return ans;
    }
}