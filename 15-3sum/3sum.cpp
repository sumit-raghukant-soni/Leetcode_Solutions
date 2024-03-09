class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int sz = nums.size(), sum = 0;
        sort(nums.begin(), nums.end());
        set<vector<int>> ans;
        for(int i=0; i<sz; i++){
            int j = i+1;
            int k = sz-1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.insert({nums[i], nums[j], nums[k]});
                    j++, k--;
                }
                else if(sum < 0){
                    j++;
                }
                else k--;
            }
        }

        return vector<vector<int>>(ans.begin(), ans.end());
    }
};