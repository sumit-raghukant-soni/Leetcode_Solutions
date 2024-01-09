class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i=0, j=0, ind=0;
        vector<int> ans(m+n, 0);
        while(i < m || j < n){
            int a = i<m ? nums1[i] : INT_MAX, b = j<n ? nums2[j] : INT_MAX;
            if(a < b) ans[ind++] = nums1[i++];
            else ans[ind++] = nums2[j++];
        }
        nums1 = ans;
    }
};