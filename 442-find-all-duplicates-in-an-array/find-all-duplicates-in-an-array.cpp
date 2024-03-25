class Solution {
public:
    int cnt[100001];
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> ans;
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            if(cnt[nums[i]]) ans.push_back(nums[i]);
            else cnt[nums[i]]++;
        }

        return ans;
    }
};