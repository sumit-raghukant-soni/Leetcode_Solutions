class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        int sz = points.size();
        multiset<pair<double, pair<int, int>> > st;

        for(int i=0; i<sz; i++){
            double tmp = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            st.insert({pow(tmp, 0.5), {points[i][0], points[i][1]}});
        }

        vector<vector<int>> ans;
        for(int i=0; i<k; i++){
            int a = st.begin()->second.first, b = st.begin()->second.second;
            // cout << a << " " << b << " " << st.begin()->first << endl;
            ans.push_back({a, b});
            st.erase(st.begin());
        }

        return ans;
    }
};