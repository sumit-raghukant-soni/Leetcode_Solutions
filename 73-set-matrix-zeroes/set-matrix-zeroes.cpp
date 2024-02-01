class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        unordered_map<int, int> r1, c1;
        int row = matrix.size(), col = matrix[0].size();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    r1[i]++, c1[j]++;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(r1[i] >= 1 || c1[j] >= 1) matrix[i][j] = 0;
            }
        }

    }
};