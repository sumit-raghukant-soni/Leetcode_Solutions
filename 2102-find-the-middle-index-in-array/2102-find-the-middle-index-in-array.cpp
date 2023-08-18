class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        int pSum[nums.size()];
        int tmp;

        for(int i=0; i<nums.size(); i++){
            pSum[i] = nums[i];
            if(i-1 >= 0) pSum[i] += pSum[i-1];
        }
        for(auto i : pSum) cout << i << " ";
        cout << endl;
        int sum = 0, size = nums.size();
        for(int i=0; i<nums.size(); i++){
            if(sum == (pSum[size-1] - pSum[i])) return i;
            sum += nums[i];
        }
        return -1;
    }
};