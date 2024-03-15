class Solution {
public:
    int normalSum(vector<int> &nums){
        int n=nums.size(), res=nums[0], maxEnd=nums[0];
        for(int i=1;i<n;i++){
            maxEnd=max(nums[i], maxEnd+nums[i]);
            res=max(res,maxEnd);
        }
    return res;
    }

    int maxSubarraySumCircular(vector<int>& nums) {
        int n=nums.size(), maxNormal=normalSum(nums), sum=0;    
        if(maxNormal<0) return maxNormal;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            nums[i]=-nums[i];
        }
        int maxCircular=sum+normalSum(nums);
        int ans=max(maxNormal,maxCircular);
    return ans;
    }
};