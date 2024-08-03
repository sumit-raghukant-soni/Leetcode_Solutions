class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int ans = 10e6, sz = nums.size();
        vector<int> tmp = nums;
        sort(tmp.begin(), tmp.end());

        for(int i=0; i<sz-2; i++){
            int second = i+1, third = sz-1;
            while(second < third){
                int sum = tmp[i] + tmp[second] + tmp[third];
                if(abs(sum-target) < abs(ans-target)){
                    ans = sum;
                }
                if(sum < target){
                    second++;
                }
                else if(sum > target){
                    third--;
                }
                else return sum;
            }
        }

        return ans;
    }
};