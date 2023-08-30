class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int r = maze.size(), c = maze[0].size();
        int er = entrance[0], ec = entrance[1];
        int dr[] = {0,-1,0,1};
        int dc[] = {-1,0,1,0};

        vector<vector<int>> vis(r,vector<int>(c,0));
        queue<pair<pair<int,int>, int>> q;
        q.push({{er,ec},0});
        vis[er][ec] = 1;
        while(!q.empty()){
            int tr = q.front().first.first, tc = q.front().first.second;
            int cnt = q.front().second;
            q.pop();
            if((tr != er || tc != ec) && (tr == 0 || tr == r-1 || tc == 0 || tc == c-1))
                return cnt;

            for(int i=0; i<4; i++){
                int row = tr + dr[i];
                int col = tc + dc[i];
                if(row < r && col < c && row >= 0 && col >= 0 && vis[row][col] == 0 && maze[row][col] == '.'){
                    vis[row][col] = 1;
                    q.push({{row, col}, cnt+1});
                }
            }
        }
        return -1;
    }
};