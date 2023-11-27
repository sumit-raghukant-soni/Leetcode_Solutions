class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        vector<vector<int>> ans(2);
        unordered_map<int, int> mp1, mp2;
        int sz1 = nums1.size(), sz2 = nums2.size();
        for(int i=0; i<sz1; i++) mp1[nums1[i]]++;
        for(int i=0; i<sz2; i++) mp2[nums2[i]]++;

        for(int i=0; i<sz1; i++){
            if(mp2.find(nums1[i]) == mp2.end() && find(ans[0].begin(), ans[0].end(), nums1[i]) == ans[0].end()) 
                ans[0].push_back(nums1[i]);
        }
        for(int i=0; i<sz2; i++){
            if(mp1.find(nums2[i]) == mp1.end() && find(ans[1].begin(), ans[1].end(), nums2[i]) == ans[1].end()) 
                ans[1].push_back(nums2[i]);
        }

        return ans;
    }
};