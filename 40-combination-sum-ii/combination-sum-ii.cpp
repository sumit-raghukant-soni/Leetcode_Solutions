class Solution {
public:
    set<vector<int>> vecs;
    void solve(vector<int>& candidates, int& sz, int& target, vector<int>& tmp, int sum, int ind){
        if(ind > sz) return;

        for(int i=ind; i<sz; i++){
            while(i!=ind && i < sz && candidates[i] == candidates[ind]) i++;
            if(i < sz && sum+candidates[i] <= target){
                tmp.push_back(candidates[i]);
                sum += candidates[i];
                if(sum == target) vecs.insert(tmp);
                else solve(candidates, sz, target, tmp, sum, i+1);
                sum -= candidates[i];
                tmp.pop_back();
            }
            else break;
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        int sz = candidates.size();
        vector<int> tmp;
        vector<vector<int>> ans;
        sort(candidates.begin(), candidates.end());

        solve(candidates, sz, target, tmp, 0, 0);

        for(auto i : vecs) ans.push_back(i);

        return ans;
    }
};