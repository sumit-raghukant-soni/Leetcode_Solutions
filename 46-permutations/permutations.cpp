class Solution {
public:
    void solve(vector<int> nums, int& sz, vector<vector<int>>& ans, int ind){
        if(ind == sz) return;
        
        for(int i=ind; i<sz; i++){
            swap(nums[ind], nums[i]);
            if(ind != i) ans.push_back(nums);
            solve(nums, sz, ans, ind+1);
            swap(nums[ind], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        int sz = nums.size();
        
        ans.push_back(nums);
        solve(nums, sz, ans, 0);            

        return ans;
    }
};