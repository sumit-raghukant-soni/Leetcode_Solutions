class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        int sz = matches.size();
        map<int, int> loss;
        unordered_map<int, int> win;
        for(int i=0; i<sz; i++)
            loss[matches[i][1]]++;
        
        vector<int> a, b;
        for(auto i : loss)
            if(i.second == 1) b.push_back(i.first);
        
        for(int i=0; i<sz; i++)
            if(loss.find(matches[i][0]) == loss.end() && win.find(matches[i][0]) == win.end()){
                a.push_back(matches[i][0]);
                win[matches[i][0]]++;
            }
        
        sort(a.begin(), a.end());
        return {a, b};
    }
};