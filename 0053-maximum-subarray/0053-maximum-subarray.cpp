class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int csum = 0, maxi=INT_MIN;

        for(int i=0; i<nums.size(); i++){
            if(csum < 0) csum = 0;
            csum += nums[i];
            maxi = maxi < csum ? csum : maxi;
        }

        return maxi;
    }
};