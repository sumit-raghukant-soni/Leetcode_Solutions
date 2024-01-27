class Solution {
public:
    void rotate2(int sr, int sc, int er, int ec, int rotations, vector<vector<int>>& matrix){
        for(int k=0; k<rotations; k++){
            int tmp = matrix[sr][sc], b;
            for(int i=sc; i<=ec; i++){
                if(i-1 >= sc){
                    b = matrix[sr][i];
                    matrix[sr][i] = tmp;
                    tmp = b;
                }
            }
            for(int i=sr+1; i<=er; i++){
                b = matrix[i][ec];
                matrix[i][ec] = tmp;
                tmp = b;
            }
            for(int i=ec-1; i>=sc; i--){
                b = matrix[er][i];
                matrix[er][i] = tmp;
                tmp = b;
            }
            for(int i=er-1; i>=sr; i--){
                b = matrix[i][sc];
                matrix[i][sc] = tmp;
                tmp = b;
            }
        }
    }
    void rotate(vector<vector<int>>& matrix) {
        int sz = matrix.size(), sr=0, sc=0, er=sz-1, ec=sz-1;
        int rotations = sz-1;
        for(int i=0; i<(sz+1)/2; i++){
            rotate2(sr, sc, er, ec, rotations, matrix);
            rotations -= 2;
            sr++, sc++, er--, ec--;
        }
    }
};