class Solution {
public:
    int trap(vector<int>& height) {
        int sz = height.size();
        int ans = 0;
        vector<int> pre(sz, 0), suf(sz, 0);
        
        for(int i=0; i<sz; i++){
            if(i-1 >= 0){
                pre[i] = max(pre[i-1], height[i-1]);
                suf[sz-1-i] = max(suf[sz-i], height[sz-1-i]);
            }
            else{
                pre[i] = height[i];
                suf[sz-1-i] = height[sz-1-i];
            }
        }

        for(int i=1; i<sz-1; i++){
            if(min(pre[i], suf[i]) > height[i]){
                ans += min(pre[i], suf[i]) - height[i];
            }
        }

        return ans;
    }
};