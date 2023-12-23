class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        int ans = 0, r = grid.size(), c = grid[0].size();
        vector<vector<bool>> vis(r, vector<bool>(c, false));
        queue<tuple<int, int, int>> q;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){ 
                    q.push({i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        while(!q.empty()){
            auto [cR, cC, dis] = q.front();
            q.pop();
            ans = max(ans, dis);

            for(int i=0; i<4; i++){
                int nR = cR + dr[i], nC = cC + dc[i];
                if(nR >= 0 && nR < r && nC >= 0 && nC < c && !vis[nR][nC] && grid[nR][nC] == 1){
                    q.push({nR, nC, dis+1});
                    vis[nR][nC] = true;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1 && !vis[i][j]) return -1;
            }
        }

        return ans;
    }
};