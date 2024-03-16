class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int sz = nums.size();
        int CurrentSum = 0, ans = 0;
        unordered_map<int, int> previousMismatch;
        
        for(int i=0; i<sz; i++){
            CurrentSum += nums[i] ? 1 : -1;
            if(CurrentSum == 0) ans = i+1;
            else{
                if(previousMismatch.find(CurrentSum) != previousMismatch.end()){
                    ans= max(ans, i-previousMismatch[CurrentSum]);
                }
                else previousMismatch[CurrentSum] = i;
            }
        }

        return ans;
    }
};