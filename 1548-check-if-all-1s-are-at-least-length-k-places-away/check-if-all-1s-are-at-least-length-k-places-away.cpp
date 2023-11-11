class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        int prev = 0, sz = nums.size();

        while(prev < sz && nums[prev] != 1) prev++;

        int curr = prev+1;
        while(curr < sz){
            while(curr < sz && nums[curr] != 1) curr++;
            if(curr < sz && nums[curr] == 1){
                if(curr - prev - 1 < k) return false;
            }
            prev = curr;
            curr++;
        }

        return true;
    }
};