class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int sz = points.size(), cnt, ans=1;

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                cnt = 2;

                for(int k=0; k<sz; k++){
                    if(k != i && k != j){
                        int dx2 = points[k][0] - points[i][0];
                        int dy2 = points[k][1] - points[i][1];

                        if(dx2 * dy == dy2 * dx) cnt++;
                    }
                }
                ans = max(ans, cnt);
            }
        }

        return ans;
    }
};