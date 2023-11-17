class Solution {
public:
    int maxWidthOfVerticalArea(vector<vector<int>>& points) {
        vector<int> tmp;
        int sz = points.size();
        for(int i=0; i<sz; i++){
            tmp.push_back(points[i][0]);
        }
        sort(tmp.begin(), tmp.end());
        int ans = 0, sz2 = tmp.size();
        for(int i=0; i<sz2-1; i++){
            ans = max(ans, tmp[i+1]-tmp[i]);
        }

        return ans;
    }
};