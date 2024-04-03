class Solution {
public:
    bool safe(vector<string> tmp, int i, int j){

        for(int k=i-1, l=j-1; k >= 0 || l >= 0; k--, l--){
            if(k >= 0 && l >= 0 && tmp[k][l] == 'Q') return false; 
            if(k >= 0 && tmp[k][j] == 'Q') return false;
            if(l >= 0 && tmp[i][l] == 'Q') return false;
        }

        for(int k=i+1, l=j-1; k < tmp.size() || l >= 0; k++, l--){
            if(k < tmp.size() && l >= 0 && tmp[k][l] == 'Q') return false; 
            if(k < tmp.size() && tmp[k][j] == 'Q') return false;
        }

        return true;
    }
    void solve(int n, vector<vector<string>>& ans, vector<string> tmp, int col){ 
        if(col == n){
            ans.push_back(tmp);
        }

        for(int i=0; i<n; i++){
            if(safe(tmp, i, col)){
                tmp[i][col] = 'Q';
                solve(n, ans, tmp, col+1);
                tmp[i][col] = '.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        vector<string> tmp;

        for(int i=0; i<n; i++){
            tmp.push_back("");
            for(int j=0; j<n; j++){
                tmp[i] += ".";
            }
        }

        solve(n, ans, tmp, 0);

        return ans;
    }
};