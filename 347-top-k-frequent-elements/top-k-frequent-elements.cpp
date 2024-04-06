class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        vector<int> ans(k, 0);

        for(int i : nums) mp[i]++;

        set<pair<int, int>> st;

        for(auto i : mp){
            st.insert({i.second, i.first});
        }

        for(int i=0; i<k; i++){
            ans[i] = st.rbegin()->second;
            auto itr = st.end();
            itr--;
            st.erase(itr);
        }

        return ans;
    }
};