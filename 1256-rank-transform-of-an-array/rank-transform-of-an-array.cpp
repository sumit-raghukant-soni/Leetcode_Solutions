class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        int k = 1, sz = arr.size();
        vector<int> ans(sz, 0);
        set<int> st;
        unordered_map<int, int> mp;

        for(int i : arr) st.insert(i);

        for(int i : st) mp[i] = k++;

        for(int i=0; i<sz; i++){
            ans[i] = mp[arr[i]];
        }

        return ans;
    }
};