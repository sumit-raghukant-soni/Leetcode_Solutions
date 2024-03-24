class Solution {
public:
    int arr[100002];
    int findDuplicate(vector<int>& nums) {
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            if(arr[nums[i]]) return nums[i];
            else arr[nums[i]]++;
        }

        return -1;
    }
};