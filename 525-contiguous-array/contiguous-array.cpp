class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> mp;
        int sz = nums.size();
        int sum = 0, ans = 0;
        for(int i=0; i<sz; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(sum == 0) ans = i+1;
            else{
                if(mp.find(sum) != mp.end()){
                    ans = max(ans, i - mp[sum]);
                }
                else mp[sum] = i;
            }
        }
        return ans;
    }
};