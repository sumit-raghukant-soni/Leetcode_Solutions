class Solution {
public:
    int numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int sz1 = nums1.size(), sz2 = nums2.size(), ans = 0;
        vector<int> mul(sz2, 0);
        for(int i=0; i<sz2; i++) mul[i] = nums2[i] * k;

        sort(mul.begin(), mul.end());

        for(int i=0; i<sz1; i++){
            int j=0;
            while(j<sz2 && mul[j] <= nums1[i]){
                if(nums1[i]%mul[j] == 0) ans++;
                j++;
            }
        }

        return ans; 
    }
};