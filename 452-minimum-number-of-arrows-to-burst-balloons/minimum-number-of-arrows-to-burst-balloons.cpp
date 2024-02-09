class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int sz = points.size(), s = -1, e = -1, cnt = 0;
        
        for(int i=0; i<sz; i++){
            if(i == 0 || points[i][0] > e){
                s = points[i][0];
                e = points[i][1];
                cnt++;
            }
            else{
                s = min(points[i][0], s);
                e = min(points[i][1], e);
            }
        }

        return cnt;
    }
};