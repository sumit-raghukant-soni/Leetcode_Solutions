class Solution {
public:
    set<vector<int>> ans;
    void solve(vector<int>& nums, int& sz, int ind){
        if(ind == sz){
            ans.insert(nums);
            return;
        }

        for(int i=ind; i<sz; i++){
            swap(nums[i], nums[ind]);
            solve(nums, sz, ind+1);
            swap(nums[i], nums[ind]);
        }

    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        int sz = nums.size();
        solve(nums, sz, 0);

        vector<vector<int>> permutations;
        vector<int> row;

        for(auto i : ans){
            row.clear();
            for(int j : i) {
                // cout << j << " ";
                row.push_back(j);
            }
            permutations.push_back(row);
            // cout << endl;
        }

        return permutations;
    }
};