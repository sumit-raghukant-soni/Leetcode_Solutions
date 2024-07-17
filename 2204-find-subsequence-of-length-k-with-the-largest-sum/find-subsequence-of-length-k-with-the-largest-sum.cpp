class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        int sz = nums.size(), j=0;
        vector<pair<int, int>> tmp;
        vector<int> ans(k, 0);

        for(int i=0; i<sz; i++){
            tmp.push_back({nums[i], i});
        }

        sort(tmp.begin(), tmp.end(), [](pair<int, int>& a, pair<int, int>& b){
            return a.first > b.first;
        });

        sort(tmp.begin(), tmp.begin()+k, [](pair<int, int>& a, pair<int, int>& b){
            return a.second < b.second;
        });

        for(int i=0; i<k; i++){
            ans[i] = tmp[i].first;
        }

        return ans;
    }
};