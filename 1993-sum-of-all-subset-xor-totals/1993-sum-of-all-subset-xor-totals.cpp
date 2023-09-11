class Solution {
public:
    void getSub(vector<int>& nums, vector<int> tmp, int sz, int idx, int& ans){
        if(idx >= sz) return;

        int tans = 0;
        for(int k=0; k<tmp.size(); k++){
            if(k == 0) tans = tmp[k];
            else tans = tans ^= tmp[k];
        }
        ans += tans;

        for(int i=idx+1; i<sz; i++){
            tmp.push_back(nums[i]);
            getSub(nums, tmp, sz, i, ans);
            tmp.pop_back();
        }
    }
    int subsetXORSum(vector<int>& nums) {
        int ans = 0;
        int sz = nums.size();
        getSub(nums, {}, sz, -1, ans);
        return ans;
    }
};