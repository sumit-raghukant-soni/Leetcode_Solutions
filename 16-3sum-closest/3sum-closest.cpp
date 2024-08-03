class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int ans = 0, sz = nums.size(), flg = 0;

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                for(int k=j+1; k<sz; k++){
                    if(flg && abs((nums[i]+nums[j]+nums[k])-target) < abs(ans-target)){
                        ans = nums[i]+nums[j]+nums[k];
                    }
                    else if(flg == 0){
                        ans = nums[i]+nums[j]+nums[k];
                        flg++;
                    }
                }
            }
        }

        return ans;
    }
};