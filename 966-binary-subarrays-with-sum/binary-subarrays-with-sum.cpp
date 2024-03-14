class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        int ans = 0, prev = 0, cnt=0;
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            if(nums[i]&1) cnt++;
            while(prev < i && cnt > goal){
                cnt -= nums[prev];
                prev++;
            }
            int tmp = prev, tcnt = cnt;
            while(tmp <= i && tcnt == goal){
                tcnt -= nums[tmp];
                tmp++;
                ans++;
            }
        }

        return ans;
    }
};