class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> mp, mp2;
        
        int sz = arr.size();
        for(int i =0; i<sz; i++)
            mp[arr[i]]++;

        for(auto i : mp)
            mp2[i.second]++;

        return mp.size() == mp2.size();
    }
};