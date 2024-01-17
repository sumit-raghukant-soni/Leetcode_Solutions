class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> mp, mp2;
        
        for(int i : arr)
            mp[i]++;

        for(auto i : mp)
            mp2[i.second]++;

        return mp.size() == mp2.size();
    }
};