class Solution {
public:
    int findMin(vector<int>& nums) {
        int sz = nums.size(), s = 0, e = sz-1;
        int mid, ans = nums[0];

        while(s <= e){
            mid = s + (e-s)/2;
            if(nums[mid] >= nums[0] && nums[mid] >= nums[sz-1]){
                s = mid + 1;
            }
            else{
                ans = nums[mid];
                e = mid-1;
            }
        }

        return ans;
    }
};