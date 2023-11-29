class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int j = 0, i = 0, sz = nums.size(), cnt = 0;
        int ans = 0;
        bool deleted = false;

        while(i < sz){
            ans = max(ans, cnt);
            if(nums[i] == 1) cnt++;
            else if(!deleted){
                deleted = true;
            }
            else{
                while(j <= i && nums[j] != 0){
                    cnt--, j++;
                }
                j++;
            }
            i++;
        }

        ans = max(ans, cnt);

        return ans - (deleted ? 0 : 1);
    }
};