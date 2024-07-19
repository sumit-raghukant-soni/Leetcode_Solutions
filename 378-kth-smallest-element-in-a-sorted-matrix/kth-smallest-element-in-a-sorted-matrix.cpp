class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int s = matrix[0][0], e = matrix[n-1][n-1];

        while(s < e){
            int mid = s + (e-s)/2;
            int count = 0;
            for(int i=0; i<n; i++){
                count += upper_bound(matrix[i].begin(), matrix[i].end(), mid) - matrix[i].begin();
            }
            
            if(count < k){
                s = mid + 1;
            }
            else{
                e = mid;
            }
        }

        return s;
    }
};