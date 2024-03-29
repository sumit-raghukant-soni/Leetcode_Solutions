class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        int n = nums.size();
        int l = 0, r = 0, cnt {};
        while(r < n)
        {
            int cur = nums[r++];
            mp[cur]++;
            while(l < r && mp[cur] > k)
            {
                mp[nums[l++]]--;
            }
            cnt = max(cnt, r - l);
        }
        return cnt;
    }
};