class Solution {
public:
    bool hasTrailingZeros(vector<int>& nums) {
        int cnt = 0, sz = nums.size();

        for(int i=0; i<sz; i++){
            if((nums[i]&1) == 0) cnt++;
            if(cnt == 2) return true;
        }

        return false;
    }
};