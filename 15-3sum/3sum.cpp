class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        set<vector<int>> st;
        int sz = nums.size();

        for(int i=0; i<sz-1; i++){
            int j = i+1, k = sz-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    st.insert({nums[i], nums[j], nums[k]});
                    int tmpJ=j, tmpK=k;
                    while(j < k && nums[j] == nums[tmpJ]) j++;
                    while(k>j && nums[k] == nums[tmpK]) k--;
                }
                else if(sum < 0){
                    j++;
                }
                else k--;
            }
            while(i+1 < sz && nums[i+1] == nums[i]) i++;
        }

        return vector<vector<int>>(st.begin(), st.end());
    }
};