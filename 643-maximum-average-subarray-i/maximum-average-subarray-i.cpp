class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double sum = 0, ans = INT_MIN;
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            sum += nums[i];
            if(i >= k-1){
                if(i >= k) sum -= nums[i-k];
                ans = max(sum/double(k), ans);
            }
        }
        return ans;
    }
};