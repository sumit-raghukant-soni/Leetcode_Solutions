class Solution {
public:
    int maxArea(vector<int>& height) {
        int ans = 0, sz = height.size();

        int s = 0, e = height.size()-1;
        while(s <= e){
            ans = max((e-s)*min(height[s], height[e]), ans);
            if(height[s] < height[e]){
                s++;
            }
            else if(height[s] > height[e]){
                e--;
            }
            else if(s+1 < sz && e-1 >= 0 && height[s+1] < height[e-1]){
                s++;
            }
            else if(s+1 < sz && e-1 >= 0 && height[s+1] > height[e-1]){
                e--;
            }
            else s++;
        }

        return ans;
    }
};