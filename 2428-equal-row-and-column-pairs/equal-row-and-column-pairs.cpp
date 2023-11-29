class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        int cnt = 0, sz = grid.size();
        vector<int> tmp(sz, 0);

        for(int i=0; i<sz; i++){

            for(int l=0; l<sz; l++) tmp[l] = 0;

            for(int j=0; j<sz; j++){
                for(int k=0; k<sz; k++){
                    if(grid[i][j] == grid[j][k]) tmp[k]++;
                }        
            }
            
            for(int t=0; t<sz; t++) if(tmp[t] == sz) cnt++;
        }

        return cnt;
    }
};