class Solution {
public:
    int si, sj;
    void solve(vector<vector<int>>& grid, int& m, int& n, int& correctBlocks, set<pair<int, int>> mp, int& cnt, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n) return;
        if(grid[i][j] == 2){
            // cout << "reached" << endl;
            if(mp.size() == correctBlocks && mp.find({si, sj}) == mp.end()){
                // cout << "this one" << endl;
                cnt++;
            }
            // for(auto i : mp) cout << i.first << ":" << i.second << ", ";
            // cout << endl;
            return;
        }

        if(grid[i][j] == 2 || grid[i][j] == -1){
            // cout << "reached but partially" << endl;
            return;
        }

        // cout << i << ":" << j << endl;

        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};

        for(int k=0; k<4; k++){
            int newI = i + dr[k], newJ = j + dc[k];
            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && mp.find({newI, newJ}) == mp.end()){
                mp.insert({newI, newJ});
                solve(grid, m, n, correctBlocks, mp, cnt, newI, newJ);
                mp.erase({newI, newJ});
            }
        }
    }

    int uniquePathsIII(vector<vector<int>>& grid) {
        int cnt = 0, m = grid.size(), n = grid[0].size(), correctBlocks = 0;
        set<pair<int, int>> mp;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) correctBlocks++;
                if(grid[i][j] == 1){
                    si = i, sj = j;
                }
            }
        }
        
        correctBlocks+= 1;
        // cout << correctBlocks << endl;
        solve(grid, m, n, correctBlocks, mp, cnt, si, sj);

        return cnt;
    }
};