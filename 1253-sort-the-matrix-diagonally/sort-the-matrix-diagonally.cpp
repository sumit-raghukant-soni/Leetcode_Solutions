class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int row = mat.size(), col = mat[0].size();
        int st = 0;
        for(; st<row; st++){
            for(int i=row-1; i>=st; i--){
                for(int j=col-1; j>=0; j--){
                    if(i-1 >= 0 && j-1 >= 0 && mat[i-1][j-1] > mat[i][j]){
                        swap(mat[i][j], mat[i-1][j-1]);
                    }
                }
            }
        }

        return mat;
    }
};