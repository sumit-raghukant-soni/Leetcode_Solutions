class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> ans(n, vector<int>(n, 0));
        
        int k=1, sz = n*n;
        int sr = 0, er = n-1, sc = 0, ec = n-1;
        while(k <= sz){
            for(int i=sc; i <= ec; i++){
                ans[sr][i] = (k++);
            }
            sr++;
            
            if(k > sz) break;
            for(int i=sr; i<=er; i++){
                ans[i][ec] = (k++);
            }
            ec--;
            
            if(k > sz) break;
            for(int i=ec; i>=sc; i--){
                ans[er][i] = (k++);
            }
            er--;
            
            if(k > sz) break;
            for(int i=er; i>=sr; i--){
                ans[i][sc] = (k++);
            }
            sc++;

        }

        return ans;
    }
};