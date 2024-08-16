class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int sz = arrays.size(), ans=INT_MIN;
        vector<int> mini(sz, 0), maxi(sz, 0);
        multiset<pair<int, int>, greater<pair<int, int>> > st;
        for(int i=0; i<sz; i++){
            st.insert({arrays[i].back(), i});
        }

        for(int i=0; i<sz; i++){
            int tmp;
            if(st.begin()->second == i){
                tmp = st.begin()->first;
                st.erase(st.begin());
                ans = max(ans, abs(arrays[i][0] - st.begin()->first));
                st.insert({tmp, i});
            }
            else{
                ans = max(ans, abs(arrays[i][0] - st.begin()->first));
            }
        }

        return ans;
    }
};