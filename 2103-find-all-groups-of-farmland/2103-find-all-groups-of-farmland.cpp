class Solution {
public:
    int r,c;
    void dfs(vector<vector<int>>& land, vector<vector<int>>& vis, int dr[], int dc[], int i, int j, int& maxI, int& maxJ){
        vis[i][j] = 1;
        maxI = max(maxI, i);
        maxJ = max(maxJ, j);
        for(int k=0; k<4; k++){
            int row = i + dr[k];
            int col = j + dc[k];
            if(row < r && col < c && row >= 0 && col >= 0 && land[row][col] == 1 && vis[row][col] == 0)
                dfs(land, vis, dr, dc, row, col, maxI, maxJ);
        }
    }
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        int cnt = 0;
        r = land.size(), c = land[0].size();
        int maxi, maxj;
        
        vector<vector<int>> vis(r, vector<int>(c, 0));
        vector<vector<int>> ans;

        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(land[i][j] == 1 && vis[i][j] == 0){
                    maxi = i, maxj = j;
                    dfs(land, vis, dr, dc, i, j, maxi, maxj);
                    ans.push_back({i,j,maxi,maxj});
                }
            }
        }
        return ans;
    }
};