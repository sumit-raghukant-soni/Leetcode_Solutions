class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        vector<pair<int, string>> mp;
        int sz = names.size();
        for(int i=0; i<sz; i++){
            mp.push_back({heights[i], names[i]});
        }
        vector<string> namesSorted;
        sort(mp.begin(), mp.end(), [&](pair<int, string>& a, pair<int, string>& b){
            return a.first > b.first;
        });

        for(int i=0; i<sz; i++){
            namesSorted.push_back(mp[i].second);
        }
        
        return namesSorted;
    }
};