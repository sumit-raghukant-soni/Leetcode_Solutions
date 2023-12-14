class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int r = grid.size(), c = grid[0].size();
        vector<vector<int>> ans(r, vector<int>(c, 0));
        vector<int> zrow(r, 0), zcol(c, 0), orow(r, 0), ocol(c, 0);
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]){
                    orow[i]++;
                    ocol[j]++;
                }
                else {
                    zrow[i]++;
                    zcol[j]++;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                ans[i][j] = orow[i] + ocol[j] - zrow[i] - zcol[j];
            }
        }

        return ans;
    }
};