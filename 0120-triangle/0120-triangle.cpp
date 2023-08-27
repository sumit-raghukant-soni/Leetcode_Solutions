class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int r = triangle.size();
        int c = r;
        vector<int> ans(c,INT_MAX);
        ans[0] = triangle[0][0];
        for(int i=1; i<r; i++){
            for(int j=triangle[i].size()-1; j>=0; j--){
                int pre = j-1 >= 0 ? ans[j-1] : INT_MAX;
                int top = ans[j];
                ans[j] = triangle[i][j] + min(pre, top);
            }
        }

        int sol = INT_MAX;
        for(auto k : ans){
            sol = sol < k ? sol : k;
        }

        return sol;
    }
};