class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        long long ans = 0, sz = nums1.size();
        vector<pair<int, int>> c;
        for(int i=0; i<sz; i++)
            c.push_back({nums2[i], nums1[i]});
        
        sort(c.rbegin(), c.rend());
        long long int sum = 0;
        multiset<int> st;
        for(int i=0; i<sz; i++){
            sum += c[i].second;
            st.insert(c[i].second);
            if(i > k-2){
                ans = max(ans, sum * c[i].first);
                sum -= *st.begin();
                st.erase(st.begin());
            }
        }

        return ans;
    }
};