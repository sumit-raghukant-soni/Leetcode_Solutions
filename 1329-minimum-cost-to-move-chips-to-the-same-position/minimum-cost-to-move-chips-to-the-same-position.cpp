class Solution {
public:
    int minCostToMoveChips(vector<int>& position) {
        int ans = INT_MAX, tmp;
        int sz = position.size();

        for(int i=0; i<sz; i++){
            int ideal = position[i];
            tmp = 0;
            for(int j=0; j<sz; j++){
                int mini = min(position[i], position[j]), maxi = max(position[i], position[j]);
                tmp += (maxi-mini)%2;
            }
            
            ans = min(tmp, ans);
        }
        return ans;
    }
};