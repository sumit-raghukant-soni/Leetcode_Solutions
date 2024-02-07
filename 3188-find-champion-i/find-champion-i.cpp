class Solution {
public:
    int findChampion(vector<vector<int>>& grid) {
        int sz = grid.size();
        int tmp;
        for(int i=0; i<sz; i++){
            tmp = 0;
            for(int j=0; j<sz; j++)
                tmp += grid[i][j];
            if(tmp == sz-1) return i;
        }
        return -1;
    }
};