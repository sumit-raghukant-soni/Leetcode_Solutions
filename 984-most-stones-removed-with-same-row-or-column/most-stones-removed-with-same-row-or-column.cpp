class Solution {
public:
    void dfs(vector<vector<int>>& stones, int& sz, vector<bool>& vis, int curr){
        vis[curr] = true;

        for(int i=0; i<sz; i++){
            if(!vis[i]){
                if(stones[i][0] == stones[curr][0]) dfs(stones, sz, vis, i);
                if(stones[i][1] == stones[curr][1]) dfs(stones, sz, vis, i);
            }
        }
    }
    int removeStones(vector<vector<int>>& stones) {
        int sz = stones.size(), groups=0;
        vector<bool> vis(sz, false);

        for(int i=0; i<sz; i++){
            if(!vis[i]){
                dfs(stones, sz, vis, i);
                groups++;
            }
        }
        // As last element of each group will not be selected, we will return total stones - last_element of each group.
        return sz - groups;
    }
};