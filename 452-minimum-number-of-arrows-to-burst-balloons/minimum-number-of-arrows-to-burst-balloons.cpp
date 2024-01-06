class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        int ans = 1, sz = points.size();

        sort(points.begin(), points.end(), [&](auto const& a, auto const& b){
            if(a[0] == b[0]) return a[1] < b[1];
            return a[0] < b[0];
        }); 

        int s=points[0][0], e=points[0][1];
        for(int i=1; i<sz; i++){
            if(points[i][0] >= s && points[i][0] <= e){
                s = max(points[i][0], s);
                e = min(points[i][1], e);
            }
            else{
                s = points[i][0], e = points[i][1];
                ans++;
            }
        }

        return ans;
    }
};