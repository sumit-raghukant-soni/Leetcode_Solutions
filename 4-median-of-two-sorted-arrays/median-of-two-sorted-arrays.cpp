class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int sz1 = nums1.size(), sz2 = nums2.size(), cnt = 0;
        int i=0, j=0, mid1 = (sz1 + sz2)/2, mid2 = ((sz1+sz2)%2 == 0) ? mid1-1 : mid1;
        int a=INT_MIN, b=INT_MIN;
        // cout << mid1 << " " << mid2 << endl;
        while(i < sz1 || j < sz2){
            int v1 = (i < sz1) ? nums1[i] : INT_MAX, v2 = (j < sz2) ? nums2[j] : INT_MAX;
            if(cnt > mid1) break;
            if(cnt == mid1) a = min(v1,v2);
            if(cnt == mid2) b = min(v1, v2);
            // cout << v1 << "==" << v2 << endl;
            // cout << a << " " << b << endl;
            if(v1 < v2){
                i++;
            }
            else{
                j++;
            }
            cnt++;
        }

        return ((a + b)*1.0) / 2.0;
    }
};