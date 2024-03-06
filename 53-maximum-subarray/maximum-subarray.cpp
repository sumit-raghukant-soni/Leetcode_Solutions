class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sz = nums.size(), ans = INT_MIN, tmp = INT_MIN;

        for(int i=0; i<sz; i++){
            if(tmp < 0) {
                tmp = nums[i];
            }
            else{
                tmp += nums[i];
            }
            ans = max(ans, tmp);
        }

        return ans;
    }
};