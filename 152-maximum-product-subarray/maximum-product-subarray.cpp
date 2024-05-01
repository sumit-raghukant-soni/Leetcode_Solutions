class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int sz = nums.size();
        int mini = nums[0], maxi = nums[0], product = nums[0];

        for(int i=1; i<sz; i++){
            int temp = max({nums[i], mini*nums[i], maxi*nums[i]});
            mini = min({nums[i], maxi*nums[i], mini*nums[i]});
            maxi = temp;
            product = max(product, maxi);
        }

        return product;
    }
};