class Solution {
public:
    // O(N) Space-Complexity Soln
    // int majorityElement(vector<int>& nums) {
    //     unordered_map<int, int> mp;
    //     int sz = nums.size();

    //     for(int i : nums){
    //         mp[i]++;
    //         if(mp[i] > sz/2) return i;
    //     }

    //     return -1;
    // }

    // OR O(1) Space-Complexity Soln
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int sz = nums.size(), cnt;

        for(int i = 0; i<sz; i++){
            cnt = 1;
            while(i+1 < sz && nums[i] == nums[i+1]){
                i++, cnt++;
            }
            if(cnt > sz/2) return nums[i];
        }

        return -1;
    }
};