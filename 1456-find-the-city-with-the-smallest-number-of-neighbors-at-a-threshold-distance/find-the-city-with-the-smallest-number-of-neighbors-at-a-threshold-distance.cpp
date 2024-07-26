class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        vector<vector<int>> curr(n, vector<int>(n, 10e5)), prev(n, vector<int>(n, 10e5));
        vector<int> num(n);

        for(auto i : edges){
            curr[i[0]][i[1]] = i[2];
            curr[i[1]][i[0]] = i[2];
        }
        for(int i=0; i<n; i++) curr[i][i] = 0;

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         cout << curr[i][j] << ", ";
        //     }
        //     cout << endl;
        // }

        for(int k=0; k<n; k++){
            prev = curr;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    // cout << i << "," << j << " = " << k << "+" << curr[i][j] << " <> " << prev[i][k] << ", " << prev[k][i] << endl;
                    curr[i][j] = min(curr[i][j], (prev[i][k] + prev[k][j]));
                }
            }
        //     for(int l=0; l<n; l++){
        //     for(int m=0; m<n; m++){
        //         cout << curr[l][m] << ", ";
        //     }
        //     cout << endl;
        // }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // cout << curr[i][j] << ", ";
                if(curr[i][j] <= distanceThreshold){
                    num[i]++;
                }
            }
            // cout << endl;
        }

        int ans, mini = INT_MAX;
        for(int i=0; i<n; i++){
            if(num[i] < mini){
                ans = i; mini = num[i];
            }
            else if(num[i] == mini) ans = i;
        }

        return ans;
    }
};