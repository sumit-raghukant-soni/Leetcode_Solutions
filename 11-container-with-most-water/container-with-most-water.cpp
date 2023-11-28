class Solution {
public:
    int maxArea(vector<int>& height) {
        int sz = height.size();
        int i=0, j=sz-1;
        int ans = 0;
        while(i<j){
            ans = max(ans, (j-i)*min(height[i], height[j]));
            if(height[i] < height[j]) i++;
            else if(height[j] < height[i]) j--;
            else if(height[i+1] > height[j-1]) j--;
            else i++;
        }

        return ans;
    }
};