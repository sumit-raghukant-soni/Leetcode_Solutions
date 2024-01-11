class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size() == 1) return true;
        int sz = nums.size();
        int reachable = 0;
        for(int i=0; i<sz; i++){
            if(reachable) reachable--;
            if(nums[i] > 0){
                reachable = max(nums[i], reachable);
            }
            if(reachable == 0 && i != sz-1) return false;
        }
        return true;
    }
};