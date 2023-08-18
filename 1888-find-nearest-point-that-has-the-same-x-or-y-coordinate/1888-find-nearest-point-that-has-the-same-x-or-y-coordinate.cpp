class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        int ans = -1;
        int ansIdx = -1;
        for(int i=0; i<points.size(); i++){
            if(points[i][0] == x || points[i][1] == y){
                if(ans == -1) {
                    ans = abs(points[i][0]-x) + abs(points[i][1]-y);
                    ansIdx = i;
                }
                else if(ans > abs(points[i][0]-x) + abs(points[i][1]-y)) {
                    ans = abs(points[i][0]-x) + abs(points[i][1]-y);
                    ansIdx = i;
                }
            }
        }
        return ansIdx;
    }
};