class Solution {
public:
    int duplicateNumbersXOR(vector<int>& nums) {
        int sz = nums.size(), ans = 0;
        vector<int> count(51, 0);

        for(int i=0; i<sz; i++){
            count[nums[i]]++;
        }

        for(int i=0; i<51; i++){
            if(count[i] == 2) ans = ans ^ i;
        }

        return ans;
    }
};