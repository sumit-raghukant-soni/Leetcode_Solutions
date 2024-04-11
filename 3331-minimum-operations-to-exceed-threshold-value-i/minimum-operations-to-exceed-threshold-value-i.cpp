class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int cnt = 0;

        for(int i : nums) if(i < k) cnt++;

        return cnt;
    }
};