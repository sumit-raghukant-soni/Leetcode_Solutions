class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int sz = grid.size();
        int sum = 0, extra = 0;
        bool vis[2501] = {false};

        for(auto i : grid){
            for(auto j : i){
                sum += j; 
                if(vis[j]) extra = j;
                vis[j] = true;
            }
        }

        int missing = ((sz*sz) * ((sz*sz)+1) / 2) - (sum - extra);
        return {extra, missing};
    }
};