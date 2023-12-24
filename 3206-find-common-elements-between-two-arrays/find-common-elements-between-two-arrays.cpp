class Solution {
public:
    vector<int> findIntersectionValues(vector<int>& nums1, vector<int>& nums2) {
        int a=0, b=0;

        unordered_map<int, int> mp1, mp2;

        for(auto i : nums1) mp1[i]++;
        for(auto i : nums2) mp2[i]++;

        for(auto i : nums1) if(mp2.find(i) != mp2.end()) a++;
        for(auto i : nums2) if(mp1.find(i) != mp1.end()) b++;

        return {a, b};
    }
};