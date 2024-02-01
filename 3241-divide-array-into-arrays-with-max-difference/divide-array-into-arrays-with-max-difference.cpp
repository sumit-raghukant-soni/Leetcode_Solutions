class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        vector<vector<int>> ans;
        sort(nums.begin(), nums.end());
        int sz = nums.size();
        for(int i=0; i<sz; i+=3){
            if(i+2 < sz && nums[i+1] - nums[i] <= k && nums[i+2] - nums[i+1] <= k && nums[i+2] - nums[i] <= k){
                ans.push_back({nums[i], nums[i+1], nums[i+2]});
            }
            else return vector<vector<int>>();
        }

        return ans;
    }
};