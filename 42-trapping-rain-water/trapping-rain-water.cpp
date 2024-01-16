class Solution {
public:
    int trap(vector<int>& height) {
        int cnt = 0, sz = height.size();
        // vector<int> dp(sz, 0);
        vector<int> left(sz, 0), right(sz, 0);
        // int j=0;
        // for(int i=0; i<sz; i++){
        //     j=i+1;
        //     int tmp = 0;
        //     while(j<sz && height[j] < height[i]){
        //         if(j == sz) break;
        //         tmp = max(tmp, height[j++]);
        //     }
        //     // cout << i << " " << j << endl;
        //     if(j != i+1){
        //         if(j < sz) tmp = height[i];
        //         int k = i+1;
        //         while(k < j && k < sz-1){
        //             dp[k] = (tmp - height[k]);
        //             cnt += (tmp - height[k]);
        //             k++;
        //         }
        //         i = k-1;
        //     }
        // }
        int tmp = 0;
        for(int i=0; i<sz; i++){
            left[i] = tmp;
            tmp = max(tmp, height[i]);
        }
        tmp = 0;
        for(int i=sz-1; i>=0; i--){
            right[i] = tmp;
            tmp = max(tmp, height[i]);
        }

        // for(int i : left) cout << i << " ";
        //     cout << endl;
        // for(int i : right) cout << i << " ";
        //     cout << endl;
        for(int i=0; i<sz; i++){
            if(min(left[i], right[i]) > height[i]){
                // cout << min(left[i], right[i]) - height[i] << " ";
                cnt += min(left[i], right[i]) - height[i];
            }
        }
        // for(int i : dp) cout << i << " ";
        // cout << endl;

        return cnt;
    }
};