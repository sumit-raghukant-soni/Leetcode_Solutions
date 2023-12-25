class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int cnt = 1, next = 1, cnt2 = 1;
        int sz = nums.size();

        for(int j=1; j<sz; j++){
            if(nums[j] > nums[j-1] && next){
                next = 0; cnt++;
            }
            else if(nums[j] < nums[j-1] && !next){
                next = 1; cnt++;
            }
        }
        next = 0;
        for(int j=1; j<sz; j++){
            if(nums[j] > nums[j-1] && next){
                next = 0; cnt2++;
            }
            else if(nums[j] < nums[j-1] && !next){
                next = 1; cnt2++;
            }
        }

        return cnt > cnt2 ? cnt : cnt2;
    }
};