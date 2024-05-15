class Solution {
public:
    int addedInteger(vector<int>& nums1, vector<int>& nums2) {
        int x = 0, sign = 1;

        for(int i : nums2) x += i;
        for(int i : nums1) x -= i;

        if(x < 0) { sign = -1; x *= -1; }

        return x == 0 ? 0 : ((x/nums1.size()) * sign);
    }
};