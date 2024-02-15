class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> ans = digits;
        int sz = ans.size();
        for(int i=sz-1; i>=0; i--){
            if(ans[i] + 1 < 10){
                ans[i]++;
                return ans;
            }
            else ans[i] = 0;
        }
        
        ans.insert(ans.begin(), 1);
        return ans;
    }
};