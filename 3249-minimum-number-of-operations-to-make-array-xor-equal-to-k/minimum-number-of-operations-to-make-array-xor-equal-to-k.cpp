class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int sum = 0, sz = nums.size(), ans=0;

        for(int i=0; i<sz; i++){
            sum ^= nums[i];
        }

        while(sum > 0 || k > 0){
            int same = (sum&1) == (k&1);
            if(!same) ans++;
            sum = sum >> 1;
            k = k >> 1;
        }

        return ans;
    }
};