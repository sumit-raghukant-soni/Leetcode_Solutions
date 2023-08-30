class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int r = grid.size(), c = grid[0].size(), fresh=0;
        int dr[] = {0,-1,0,1};
        int dc[] = {-1,0,1,0};
        vector<vector<int>> vis(r, vector<int>(c, 0));
        queue<pair<int, int>> q;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 1;
                    q.push({i,j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;
        int cnt = 0;
        q.push({-100, -100});
        while(!q.empty()){
            int row = q.front().first, col = q.front().second;
            q.pop();
            if(row == -100 && col == -100){
                if(!q.empty()){
                    cnt++;
                    q.push({-100, -100});
                } else break;
            }
            for(int i=0; i<4; i++){
                int tr = row + dr[i];
                int tc = col + dc[i];
                if(tr < r && tc < c && tr >= 0 && tc >= 0 && grid[tr][tc] == 1 && vis[tr][tc] == 0){
                    fresh--;
                    vis[tr][tc] = 1;
                    q.push({tr,tc});
                }
            }
        }

        return fresh == 0 ? cnt : -1;
    }
};