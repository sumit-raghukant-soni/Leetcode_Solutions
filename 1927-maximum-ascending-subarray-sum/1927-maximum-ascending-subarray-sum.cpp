class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        int ans = 0, size = nums.size();
        int tmp=0;
        for(int i=0; i<size; i++){
            if(tmp != 0 && nums[i] <= nums[i-1]){
                ans = max(ans, tmp);
                tmp = 0;
            }
            tmp += nums[i];
        }

        ans = max(ans, tmp);
        return ans;
    }
};