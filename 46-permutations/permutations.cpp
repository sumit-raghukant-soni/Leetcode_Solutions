class Solution {
public:
    void solve(vector<vector<int>>& ans, vector<int>& nums, int& sz, int ind){
        if(ind == sz-1) {
            ans.push_back(nums);
            return;
        }

        for(int i=ind; i<sz; i++){
            swap(nums[ind], nums[i]);
            solve(ans, nums, sz, ind+1);
            swap(nums[ind], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        int sz = nums.size();

        solve(ans, nums, sz, 0);

        return ans;
    }
};