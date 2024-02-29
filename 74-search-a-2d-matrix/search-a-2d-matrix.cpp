class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int r = matrix.size(), c = matrix[0].size();
        int s = 0, e = (r*c)-1;
        
        while(s <= e){
            int mid = (e+s)/2;
            int row = mid/c, col = mid%c;

            if(matrix[row][col] < target){
                s = mid+1;
            }
            else if(matrix[row][col] > target){
                e = mid-1;
            }
            else return true;
        }

        return false;
    }
};