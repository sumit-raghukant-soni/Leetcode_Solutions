class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double avg=INT_MIN, sum=0;

        for(int i=0; i<nums.size(); i++){
            sum += nums[i];
            if(i >= k-1){
                avg = max(avg, sum/k);
                sum -= nums[i-(k-1)];
            }
        }

        return avg;
    }
};