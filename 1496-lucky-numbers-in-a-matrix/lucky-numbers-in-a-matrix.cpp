class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        vector<int> rows(m, INT_MAX), cols(n, INT_MIN), ans;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rows[i] = min(rows[i], matrix[i][j]);
                cols[j] = max(cols[j], matrix[i][j]);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i] == cols[j]) ans.push_back(rows[i]);
            }
        }

        return ans;
    }
};