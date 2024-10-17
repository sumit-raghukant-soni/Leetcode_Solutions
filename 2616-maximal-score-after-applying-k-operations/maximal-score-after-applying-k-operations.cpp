class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        long long ans = 0;

        multiset<int> st;

        for(int i=0; i<nums.size(); i++){
            st.insert(nums[i]);
        }

        for(int i=0; i<k; i++){
            auto last = prev(st.end());
            // cout << *last << endl;
            int tmp = *last;
            st.erase(last);
            ans += tmp;
            st.insert(ceil(tmp/3.0));
        }

        return ans;
    }
};