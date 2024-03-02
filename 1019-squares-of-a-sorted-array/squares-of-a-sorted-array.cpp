class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> ans = nums;

        sort(ans.begin(), ans.end(), [&](int a, int b){return abs(a) < abs(b);});
        for_each(ans.begin(), ans.end(), [](int& a){ a *= a;});

        return ans;
    }
};