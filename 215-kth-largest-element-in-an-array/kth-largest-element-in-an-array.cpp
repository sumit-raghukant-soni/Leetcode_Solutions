class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int sz = nums.size();
        int pivot = nums[rand()%sz];
        vector<int> left, right, mid;
        for(int i=0; i<sz; i++){
            if(nums[i] < pivot) left.push_back(nums[i]);
            else if(nums[i] == pivot) mid.push_back(nums[i]);
            else right.push_back(nums[i]);
        }

        if(k <= right.size()) return findKthLargest(right, k);
        k -= right.size();
        if(k <= mid.size()) return pivot;
        k -= mid.size();
        return findKthLargest(left, k);
    }
};