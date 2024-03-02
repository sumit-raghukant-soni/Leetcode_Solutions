class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int s = 0, e = nums.size()-1, sz = nums.size();
        int ans = 0;

        while(s <= e){
            int mid = s + (e-s)/2;
            int left = mid-1 >= 0 ? nums[mid-1] : INT_MIN;
            int right = mid+1 < sz ? nums[mid+1] : INT_MIN;
            if(left < nums[mid] && right < nums[mid]){
                return mid;
            }
            else if(left > nums[mid]){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }

        return ans;
    }
};