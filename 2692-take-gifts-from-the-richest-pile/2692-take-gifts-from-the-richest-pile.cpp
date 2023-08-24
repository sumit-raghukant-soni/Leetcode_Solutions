class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        multiset<int, greater<int>> st(gifts.begin(), gifts.end());
        long long ans = 0, cnt = k;
        while(cnt--){
            int val = floor(sqrt(*(st.begin())));
            st.erase(st.begin());
            st.insert(val);
        }
        while( st.size()){
            ans += *(st.begin());
            st.erase(st.begin());
        }
        return ans;
    }
};