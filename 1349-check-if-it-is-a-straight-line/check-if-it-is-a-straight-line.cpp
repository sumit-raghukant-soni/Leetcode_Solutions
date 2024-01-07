class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        sort(coordinates.begin(), coordinates.end());
        double slope = INT_MAX;
        for(int i=1; i<coordinates.size(); i++){
            if(slope == INT_MAX){
                slope = double(coordinates[i][1] - coordinates[i-1][1])/double(coordinates[i][0] - coordinates[i-1][0]);
            }
            else{
                double tmp = double(coordinates[i][1] - coordinates[i-1][1])/double(coordinates[i][0] - coordinates[i-1][0]);
                if(slope != tmp) return false;
            }
        }
        return true;
    }
};