class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        int sz1 = nums1.size(), sz2 = nums2.size();
        int i=0, j=0;
        while(i < sz1 && j < sz2){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else return nums1[i];
        }

        return -1;
    }
};