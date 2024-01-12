class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int ind = 0, sz = nums.size(), prev = INT_MAX, cnt = 0;

        for(int i=0; i<sz; i++){
            if(nums[i] != prev){
                prev = nums[i];
                nums[ind++] = nums[i];
                cnt = 1;
            }
            else if(cnt < 2){
                nums[ind++] = nums[i];
                cnt++;
            }
        }

        return ind;
    }
};