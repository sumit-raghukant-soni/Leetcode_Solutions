class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int sr = 0, sc = 0, er = matrix.size()-1, ec = matrix[0].size()-1;
        vector<int> result;
        int k = matrix.size() * matrix[0].size();

        while(k > 0){
            for(int i=sc; i<=ec && k-- > 0; i++){
                result.push_back(matrix[sr][i]);
            }
            sr++;
            for(int i=sr; i<=er  && k-- > 0; i++){
                result.push_back(matrix[i][ec]);
            }
            ec--;
            for(int i=ec; i>= sc && k-- > 0; i--){
                result.push_back(matrix[er][i]);
            }
            er--;
            for(int i=er; i>=sr && k-- > 0; i--){
                result.push_back(matrix[i][sc]);
            }
            sc++;
        }
        
        return result;
    }
};