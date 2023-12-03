class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        ios_base::sync_with_stdio(false); cin.tie(NULL), cout.tie(NULL);
        int ans = 0;
        int x = points[0][0], y = points[0][1];
        for(auto i : points){
            ans += max(abs(x-i[0]), abs(y-i[1]));
            x = i[0], y = i[1];
        }
        return ans;
    }
};