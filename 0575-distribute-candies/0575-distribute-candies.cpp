class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        unordered_map<int, int> mp;

        for(auto i : candyType) mp[i]++;
        
        return min(candyType.size()/2, mp.size());
    }
};