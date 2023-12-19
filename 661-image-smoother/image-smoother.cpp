class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        int r = img.size(), c = img[0].size();
        vector<vector<int>> ans(r, vector<int>(c, 0));

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int cnt = 1;
                ans[i][j] += img[i][j];
                if(i-1 >= 0){ans[i][j] += img[i-1][j]; cnt++;}
                if(i+1 < r){ans[i][j] += img[i+1][j]; cnt++;}
                if(j-1 >= 0){ans[i][j] += img[i][j-1]; cnt++;}
                if(j+1 < c){ans[i][j] += img[i][j+1]; cnt++;}
                if(i-1 >= 0 && j-1 >= 0){ans[i][j] += img[i-1][j-1]; cnt++;}
                if(i-1 >= 0 && j+1 < c){ans[i][j] += img[i-1][j+1]; cnt++;}
                if(i+1 < r && j-1 >= 0){ans[i][j] += img[i+1][j-1]; cnt++;}
                if(i+1 < r && j+1 < c){ans[i][j] += img[i+1][j+1]; cnt++;}
                ans[i][j] /= cnt;
            }
        }

        return ans;
    }
};