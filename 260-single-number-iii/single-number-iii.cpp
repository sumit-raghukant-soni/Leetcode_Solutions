class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int sz = nums.size();
        vector<int> ans;
        unordered_set<int> st;
        
        for(int i=0; i<sz; i++){
            if(st.find(nums[i]) != st.end())
                st.erase(nums[i]);
            else
                st.insert(nums[i]);
        }

        for(int i : st) ans.push_back(i);
        
        return ans;
    }
};