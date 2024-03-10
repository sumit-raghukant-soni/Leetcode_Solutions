class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        int arr1[1001] = {0}, arr2[1001] = {0};
        for(int i : nums1) arr1[i]++;
        for(int i : nums2) arr2[i]++;

        vector<int> ans;
        for(int i=0; i<1001; i++){
            if(arr1[i] != 0 && arr2[i] != 0) ans.push_back(i);
        }

        return ans;
    }
};