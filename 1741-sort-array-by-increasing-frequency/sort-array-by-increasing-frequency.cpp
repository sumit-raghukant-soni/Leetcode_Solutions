class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int, int> mp;
        for(int i : nums) mp[i]++;

        sort(nums.begin(), nums.end(), [&](int& a, int& b){
            return (mp[a] == mp[b]) ? a > b :  mp[a] < mp[b];
        });

        return nums;
    }
};