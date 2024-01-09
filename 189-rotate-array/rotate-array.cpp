class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k%nums.size();
        int sz = nums.size();
        vector<int> tmp(nums.begin(), nums.begin()+(sz-k));
        nums.erase(nums.begin(), nums.begin()+(sz-k));
        nums.insert(nums.end(), tmp.begin(), tmp.end());
    }
};