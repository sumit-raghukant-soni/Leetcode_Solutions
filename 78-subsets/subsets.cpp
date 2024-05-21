class Solution {
public:
    void getSubsets(vector<int>& nums, int ind, int sz, vector<int> tmp, vector<vector<int>>& ans){
        if(ind == sz) return;

        getSubsets(nums, ind+1, sz, tmp, ans);
        tmp.push_back(nums[ind]);
        ans.push_back(tmp);
        getSubsets(nums, ind+1, sz, tmp, ans);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> tmp;
        ans.push_back(tmp);
        int sz = nums.size();

        getSubsets(nums, 0, sz, tmp, ans);

        return ans;
    }
};