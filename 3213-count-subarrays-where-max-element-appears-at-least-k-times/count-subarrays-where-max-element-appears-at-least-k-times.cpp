class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        long long ans = 0;
        int s=0,e=0, sz = nums.size();
        int maxi = *max_element(nums.begin(), nums.end()), cnt = 0;

        while(e < sz){
            if(maxi == nums[e]) cnt++;
            while(cnt >= k){
                if(nums[s] == maxi) cnt--;
                s++;
                ans += sz - e;
            }
            e++;
        }

        return ans;
    }
};