class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int ans = INT_MAX, sum = 0, s = 0;
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            if(sum < target)
                sum += nums[i];
            if(sum >= target){
                while(sum >= target && s <= i){
                    ans = min(ans, i-s+1);
                    sum -= nums[s];
                    s++;
                }
            }
        }

        if(ans == INT_MAX) return 0;
        return ans;
    }
};