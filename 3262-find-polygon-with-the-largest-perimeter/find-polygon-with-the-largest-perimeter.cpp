class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        long long ans = nums[0] + nums[1], mxAns = -1;
        int sz = nums.size();

        for(int i=2; i<sz; i++){
            ans += nums[i];
            if(ans-nums[i] > nums[i]) mxAns = ans;
        }

        return mxAns;
    }
};