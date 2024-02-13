class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int cnt = 0, sz = nums.size(), j=0;

        for(int i=0; i<sz; i++){
            j=i, cnt = 0;
            while(j < sz && nums[i] == nums[j]){
                j++;
                cnt++;
            }
            if(cnt > sz/2) return nums[i];
        }

        return -1;
    }
};