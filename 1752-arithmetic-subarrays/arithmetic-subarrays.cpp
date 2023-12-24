class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
        vector<bool> ans;
        int sz = nums.size(), m = l.size();

        for(int i=0; i<m; i++){
            vector<int> tmp(nums.begin()+l[i], nums.begin()+r[i]+1);
            sort(tmp.begin(), tmp.end());
            int sz2 = tmp.size(), diff = INT_MAX;
            bool flg = true;
            for(int j=1; j<sz2; j++){
                if(diff == INT_MAX) diff = tmp[j-1] - tmp[j];
                else if(diff != tmp[j-1] - tmp[j]){
                    flg = false; break;
                }
            }
            ans.push_back(flg);
        }
        return ans;
    }
};