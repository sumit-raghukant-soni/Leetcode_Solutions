class Solution {
public:
    int trap(vector<int>& height) {
        int cnt = 0, sz = height.size();
        vector<int> capacity(sz, 0);

        int tmp = 0;
        for(int i=0; i<sz; i++){
            capacity[i] = tmp;
            tmp = max(tmp, height[i]);
        }
        tmp = 0;
        for(int i=sz-1; i>=0; i--){
            capacity[i] = min(tmp, capacity[i]);
            tmp = max(tmp, height[i]);
        }

        for(int i=0; i<sz; i++){
            if(capacity[i] > height[i]){
                cnt += capacity[i] - height[i];
            }
        }

        return cnt;
    }
};