class Solution {
public:
    void solve(vector<int> nums, int& sz, vector<vector<int>>& ans, int ind){
        if(ind == sz-1){
            ans.push_back(nums);
            return;
        }
        
        for(int i=ind; i<sz; i++){
            swap(nums[ind], nums[i]);
            solve(nums, sz, ans, ind+1);
            swap(nums[ind], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        int sz = nums.size();
        
        solve(nums, sz, ans, 0);            

        return ans;
    }
};