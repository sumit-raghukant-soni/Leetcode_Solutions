class Solution {
public:
    void solve(vector<int>& nums, int& sz, set<vector<int>>& st, vector<int> tmp, int ind){
        if(ind >= sz) return;

        for(int i=ind; i<sz; i++){
            solve(nums, sz, st, tmp, i+1);
            tmp.push_back(nums[i]);
            st.insert(tmp);
            solve(nums, sz, st, tmp, i+1);
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        int sz = nums.size();
        vector<vector<int>> ans;
        set<vector<int>> st;
        vector<int> tmp;

        sort(nums.begin(), nums.end());
        ans.push_back(tmp);

        for(int i=0; i<sz; i++){
            solve(nums, sz, st, {}, i);
        }

        for(auto i : st){
            ans.push_back(i);
        }

        return ans;
    }
};