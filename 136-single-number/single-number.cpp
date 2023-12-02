class Solution {
public:
    int singleNumber(vector<int>& nums) {
        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
        int XOR = 0;
        for(int i : nums) XOR = XOR ^ i;
        return XOR;
    }
};