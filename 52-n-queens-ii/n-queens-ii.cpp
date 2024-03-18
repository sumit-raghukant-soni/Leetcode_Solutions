class Solution {
public:
    unordered_map<int, int> row, diag1, diag2, mp;
    void solve(int col, int& n, int& ans){
        if(col == n){
            ans++;
            return;
        }

        for(int i=0; i<n; i++){
            if(row.find(i) == row.end() && diag1.find(col+i) == diag1.end() && diag2.find((n-1) + (col-i)) == diag2.end()){
                row[i]++;
                diag1[col+i]++;
                diag2[(n-1) + (col-i)]++;
                solve(col+1, n, ans);
                row.erase(i);
                diag1.erase(col+i);
                diag2.erase((n-1) + (col-i));
            }
        }
    }
    int totalNQueens(int n) {
        int ans = 0;

        // vector<vector<int>> board(n, vector<int>(n, 0));

        solve(0, n, ans);

        return ans;
    }
};