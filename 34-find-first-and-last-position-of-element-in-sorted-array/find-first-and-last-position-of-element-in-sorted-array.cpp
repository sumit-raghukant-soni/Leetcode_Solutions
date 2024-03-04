class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int sz = nums.size();
        int first = -1, last = -1, s = 0, e = sz-1;
        int mid;

        while(s <= e){
            mid = s + (e-s)/2;
            if(nums[mid] >= target){
                e = mid-1;
                if(target == nums[mid]) first = mid;
            }
            else {
                s = mid + 1;
            }
        }
        s = 0, e = sz-1;
        while(s <= e){
            mid = s + (e-s)/2;
            if(nums[mid] > target){
                e = mid-1;
            }
            else {
                s = mid + 1;
                if(target == nums[mid]) last = mid;
            }
        }

        return {first, last};
    }
};