class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int r = matrix.size(), c = matrix[0].size(), ans = INT_MIN;

        for(int t=0; t<c; t++){
            vector<int> sum(r, 0);
            for(int j=t; j<c; j++){
                // cout << "sum" << endl;
                for(int i=0; i<r; i++){
                    sum[i] += matrix[i][j];
                    // cout << sum[i] << " ";
                }
                // cout << endl;
                set<int> set = {0}; int run_sum = 0;
                for(int val : sum){
                    run_sum += val;
                    auto it = set.lower_bound(run_sum - k);
                    if(it != set.end()){
                        // cout << ans << " " << run_sum << " " << *it << endl;
                        ans = max(ans, run_sum - *it);
                    }
                    set.insert(run_sum);
                }
            }
        }

        return ans;
    }
};