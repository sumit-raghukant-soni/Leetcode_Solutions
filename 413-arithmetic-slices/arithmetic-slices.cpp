class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int sz = nums.size();
        int ans = 0, prev = 0;

        for(int i=2; i<sz; i++){
            if(nums[i]-nums[i-1] == nums[i-1] - nums[i-2]){
                prev++;
                ans += prev;
            }
            else prev = 0;
        }

        return ans;
    }
};