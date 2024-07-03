class Solution {
public:
    int minDifference(vector<int>& nums) {
        int sz = nums.size(), ans;
        if(sz <= 4) return 0;

        sort(nums.begin(), nums.end());

        // for(int i : nums) cout << i << " ";
        // cout << endl;

        // cout << (nums[sz-1] - nums[0]) << " " << (nums[sz-4] - nums[0]) << " " << (nums[sz-1] - nums[3]) << " " << (nums[sz-3] - nums[1]) << ' ' << (nums[sz-2] - nums[2]);

        return min({(nums[sz-1] - nums[0]), (nums[sz-4] - nums[0]), (nums[sz-1] - nums[3]), (nums[sz-3] - nums[1]), (nums[sz-2] - nums[2])});
    }
};