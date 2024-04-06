class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        vector<int>left,mid,right;
        int pivot = nums[rand()%nums.size()];
        for(auto x:nums){
            if(x>pivot) right.push_back(x);
            else if(x==pivot) mid.push_back(x);
            else left.push_back(x);
        }
        if(k<=right.size()) return findKthLargest(right,k);
        k-=right.size();
        if(k<=mid.size()) return pivot;
        k-=mid.size();
        return findKthLargest(left,k);
    }
};