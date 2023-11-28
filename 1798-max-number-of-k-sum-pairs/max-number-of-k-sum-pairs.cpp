class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int cnt = 0, sz = nums.size();
        unordered_map<int, int> mp;

        for(int i=0; i<sz; i++) if(nums[i] < k) mp[nums[i]]++;

        for(int i=0; i<sz; i++){
            if(nums[i] == k - nums[i]){
                if(mp[nums[i]] > 1){
                    mp[nums[i]]-=2;
                    cnt++;
                }
                else mp.erase(nums[i]);
            }
            else if(mp.find(k - nums[i]) != mp.end()){
                if(mp[k - nums[i]] > 0 && mp[nums[i]] > 0){
                    mp[nums[i]]--;
                    mp[k - nums[i]]--;
                    cnt++;
                }
                else if(mp[nums[i]] == 0) mp.erase(nums[i]);
                else if(mp[k - nums[i]] == 0) mp.erase(k - nums[i]);
            }
        }

        return cnt;
    }
};