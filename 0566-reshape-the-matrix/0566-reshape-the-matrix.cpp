class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        if(mat.size()*mat[0].size() != r*c) return mat;
        vector<vector<int>> ans(r, vector<int>(c,0));
        int row=0, col=-1;
        for(auto i : mat){
            for(auto j : i){
                if(col == c-1){
                    row++;
                    col=0;
                }
                else col++;
                ans[row][col] = j;
            }
        }
        return ans;
    }
};