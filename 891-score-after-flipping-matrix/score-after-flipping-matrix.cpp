class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int r = grid.size(), c = grid[0].size(), ans = 0;

        vector<vector<int>> tmp = grid;

        for(int i=0; i<r; i++){
            for(int j=c-1; j>=0; j--){
                if(tmp[i][0] == 0){
                    tmp[i][j] = (tmp[i][j] == 1) ? 0 : 1;
                }
            }
        }

        // for(auto i : tmp){
        //     for(int j : i) cout << j << " ";
        //     cout << endl;
        // }

        int cnt, val = 1;
        for(int i=c-1; i>=0; i--){
            cnt = 0;
            for(int j=0; j<r; j++){
                cnt += tmp[j][i];
            }
            if(cnt < (r - cnt)){
                for(int j=0; j<r; j++){
                    tmp[j][i] = 1 ^ tmp[j][i];
                }
                ans += val * (r-cnt);
            }
            else ans += val * cnt;
            // cout << i << " " << cnt << " " << (r-cnt) << " " << ans << endl;
            val*=2;
        }


        // for(auto i : tmp){
        //     for(int j : i) cout << j << " ";
        //     cout << endl;
        // }

        return ans;
    }
};