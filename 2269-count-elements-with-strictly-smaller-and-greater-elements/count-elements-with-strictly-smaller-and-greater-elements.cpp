class Solution {
public:
    int countElements(vector<int>& nums) {
        if(nums.size() <= 2) return 0;

        int sz = nums.size();
        int mini = INT_MAX, maxi = INT_MIN, mcnt=0, Mcnt=0;
        for(int i=0; i<sz; i++){
            if(nums[i] < mini){
                mcnt = 1;
                mini = nums[i];
            }
            else if(nums[i] == mini) mcnt++;
            if(nums[i] > maxi){
                Mcnt = 1;
                maxi = nums[i];
            }
            else if(nums[i] == maxi) Mcnt++;
        }

        if(mcnt == sz) return 0;
        return sz - (mcnt + Mcnt);
    }
};