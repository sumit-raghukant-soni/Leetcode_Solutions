class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int row = image.size(), col = image[0].size();
        vector<vector<int>> ans = image;
        vector<vector<int>> vis(row, vector<int>(col, 0));
        vis[sr][sc] = 1;
        queue<pair<int, int>> q;
        q.push({sr, sc});
        int src = ans[sr][sc];
        int dr[] = {1, 0, -1, 0}, dc[] = {0, -1, 0, 1};
        while(!q.empty()){
            auto front = q.front();
            q.pop();
            int r = front.first, c = front.second;
            
            if(ans[r][c] == src){
                ans[r][c] = color;
                for(int i=0; i<4; i++){
                    int rw = r + dr[i], cl = c + dc[i];
                    if(rw >= 0 && rw < row && cl >= 0 && cl < col && !vis[rw][cl] && ans[rw][cl] == src){
                        vis[rw][cl] = 1;
                        q.push({rw, cl});
                    }
                }
            }
        }

        return ans;
    }
};