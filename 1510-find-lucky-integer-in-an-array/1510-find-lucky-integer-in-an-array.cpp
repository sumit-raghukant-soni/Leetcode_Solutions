class Solution {
public:
    int findLucky(vector<int>& arr) {
        map<int, int, greater<int>> mp;

        for(auto i : arr) mp[i]++;

        for(auto i : mp) if(i.first == i.second) return i.first;

        return -1;
    }
};