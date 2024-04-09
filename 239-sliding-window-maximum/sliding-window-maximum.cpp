class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int sz = nums.size();
        vector<int> ans(sz-k+1);
        multiset<int, greater<int>> st;

        for(int i=0; i<sz; i++){
            st.insert(nums[i]);
            if(i>=k-1){
                ans[i-k+1] = *st.begin();
                st.erase(st.find(nums[i-k+1]));
            }
        }

        return ans;
    }
};