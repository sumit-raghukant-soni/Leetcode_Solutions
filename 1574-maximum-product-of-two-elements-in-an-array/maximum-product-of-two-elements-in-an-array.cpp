class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int ans = INT_MIN;
        int sz = nums.size();

        for(int i=0; i<sz-1; i++){
            for(int j=i+1; j<sz; j++){
                ans = max(ans, (nums[i]-1) * (nums[j]-1));
            }
        }

        return ans;
    }
};