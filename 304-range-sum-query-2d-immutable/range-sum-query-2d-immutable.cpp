class NumMatrix {
    vector<vector<int>> sum;
    int r, c;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        r = matrix.size(), c = matrix[0].size();
        this->sum = vector<vector<int>>(r, vector<int>(c, 0));

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                this->sum[i][j] = (j-1 >= 0 ? sum[i][j-1] : 0) + matrix[i][j];
                // cout << sum[i][j] << " ";
            }
            // cout << endl;
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int regionSum = 0, cols = (col2 - col1 + 1);
        for(int i=row1; i<=row2; i++){
            regionSum += -(col1-1 >= 0 ? sum[i][col1-1] : 0) + sum[i][col2];
            // cout << -(col1-1 >= 0 ? sum[i][col1-1] : 0) <<":"<< sum[i][col2] << " = " << cols << endl;
        }
        return regionSum;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */