class Solution {
public:
    void solve(vector<int>& arr, int& sz, int target, vector<vector<int>>& ans, vector<int> tmp, int i){
        if(target == 0){
            ans.push_back(tmp);
            return;
        }
        else if(i >= sz || target < 0) return;

        int prev = -1;
        for(; i<sz; i++){
            if(arr[i] == prev) continue;
            tmp.push_back(arr[i]);
            solve(arr, sz, target-arr[i], ans, tmp, i+1);
            tmp.pop_back();
            prev = arr[i];
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        int sz = candidates.size();
        vector<int> arr = candidates;
        sort(arr.begin(), arr.end());

        vector<vector<int>> ans;

        solve(arr, sz, target, ans, {}, 0);

        return ans;
    }
};