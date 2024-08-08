class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        vector<vector<int>> ans;
        int sr=rStart, sc=cStart, er=rStart, ec=cStart;

        ans.push_back({sr, sc});
        
        while(sr >= 0 || sc >= 0 || er < rows || ec < cols){
            ec++;
            if(sr >= 0){
                // cout << "l2r " << sr << endl;
                // cout << max(sc+1, 0) << " => " << min(ec, cols-1) << endl;
                for(int i=max(sc+1, 0); i<=ec && i<cols; i++){
                    ans.push_back({sr, i});
                }
            }
            er++;
            if(ec < cols){
                // cout << "t2b " << ec << endl;
                // cout << max(sr+1, 0) << " => " << min(er, rows-1) << endl;
                for(int i=max(0, sr+1); i<=er && i<rows; i++){
                    ans.push_back({i, ec});
                }
            }
            sc--;
            if(er < rows){
                // cout << "r2l " << er << endl;
                // cout << min(ec-1, cols-1) << " => " << max(sc, 0) << endl;
                for(int i=min(ec-1, cols-1); i>=sc && i>=0; i--){
                    ans.push_back({er, i});
                }
            }
            sr--;
            if(sc >= 0){
                // cout << "b2t " << sc << endl;
                // cout << max(er-1, 0) << " => " << max(sr, 0) << endl;
                for(int i=min(er-1, rows-1); i>=sr && i>=0; i--){
                    ans.push_back({i, sc});
                }
            }
        }

        return ans;
    }
};