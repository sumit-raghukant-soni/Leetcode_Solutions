class Solution {
private:
    void solve(int k, int n, vector<vector<int>> &ans, vector<int> data, int s, int idx){
        if(idx >= k){
            int sum = accumulate(data.begin(), data.end(), 0);
            if(sum == n)
                ans.push_back(data);
            return;
        }
        for(int i=s; i<=9; i++){
            data[idx] = i;
            solve(k, n, ans, data, i+1, idx+1);
        }
    }
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans;
        vector<int> temp(k);
        solve(k, n, ans, temp, 1, 0);
        return ans;
    }
};