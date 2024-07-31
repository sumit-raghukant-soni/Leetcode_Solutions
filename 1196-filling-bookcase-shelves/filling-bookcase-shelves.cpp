class Solution {
public:
    int solve(vector<int>& dp, vector<vector<int>>& books, int& sz, int& W, int tW, int ind){
        // cout << i+1 << " " << sz << endl;
        if(ind >= sz) return 0;
        // cout << "here" << endl;
        if(dp[ind] != -1) return dp[ind];
        
        int next = INT_MAX, tmp, curr = INT_MIN, i = ind;
        for(; i<sz; i++){
            if(tW-books[i][0] >= 0){
                tW -= books[i][0];
                curr = max(books[i][1], curr);
                tmp = solve(dp, books, sz, W, W, i+1);
            }
            else break;
            next = min(next, tmp + curr);
            // cout << "at " << i+1 << " " << curr << " + " << next << endl;
        }
        return dp[ind] = next;
    }
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        int ans = INT_MAX, sz = books.size();
        vector<int> dp(sz, -1);

        return solve(dp, books, sz, shelfWidth, shelfWidth, 0);

        // return ans;
    }
};