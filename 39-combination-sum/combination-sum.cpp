class Solution {
public:
    void solve(vector<int>& candidates, int& sz, int target, vector<vector<int>>& ans, vector<int> tmp){        
        if(target == 0){
            sort(tmp.begin(), tmp.end());
            if(find(ans.begin(), ans.end(), tmp) == ans.end()) ans.push_back(tmp);
            return;
        }

        for(int i=0; i < sz; i++){
            if( candidates[i] <= target ){
                tmp.push_back(candidates[i]);
                solve(candidates, sz, target-candidates[i], ans, tmp);
                tmp.pop_back();
            }
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        int sz = candidates.size();
        vector<vector<int>> ans;

        solve(candidates, sz, target, ans, {});

        return ans;
    }
};