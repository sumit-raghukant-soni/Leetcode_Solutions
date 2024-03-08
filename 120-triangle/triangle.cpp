class Solution {
public:
    int minimumTotal(vector<vector<int>>& t) {
        int sz = t.size(), col = 2;
        vector<vector<int>> tmp = t;
        if(sz == 1) return t[0][0];

        for(int i=1; i<sz; i++){
            for(int j=0; j<col; j++){
                int v1 = j-1 >= 0 ? tmp[i-1][j-1] : INT_MAX, v2 = j == col-1 ? INT_MAX : tmp[i-1][j];
                tmp[i][j] += min(v1, v2);
            }
            col++;
        }

        int ans = INT_MAX;
        for(int i=0; i<tmp[sz-1].size(); i++){
            ans = min(ans, tmp[sz-1][i]);
        }

        return ans;
    }
};