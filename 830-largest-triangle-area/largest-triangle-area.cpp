class Solution {
public:
    double largestTriangleArea(vector<vector<int>>& points) {
        double ans = INT_MIN;
        int sz = points.size();

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                for(int k=j+1; k<sz; k++){
                    double x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1], x3 = points[k][0], y3 = points[k][1];
                    ans = max(ans, abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)))/2);
                }
            }
        }
        return ans;
    }
};