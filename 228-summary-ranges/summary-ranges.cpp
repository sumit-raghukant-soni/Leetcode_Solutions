class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ans;
        int sz = nums.size();
        int prev, curr;
        bool cSet = false, pSet = false;
        int pSign = 1, cSign = 1;

        for(int i=0; i<sz; i++){
            if(!pSet){
                pSet = true;
                prev = nums[i];
            }
            else if(!cSet && nums[i] == prev + 1){
                cSet = true;
                curr = nums[i];
            }
            else if(!cSet){
                ans.push_back(to_string(prev));
                prev = nums[i];
            }
            else if(nums[i] == curr + 1){
                curr = nums[i];
            }
            else{
                ans.push_back(to_string(prev) + "->" + to_string(curr));
                prev = nums[i];
                cSet = false;
            }
        }

        if(pSet && cSet) ans.push_back(to_string(prev) + "->" + to_string(curr));
        else if(pSet) ans.push_back(to_string(prev));

        return ans;
    }
};