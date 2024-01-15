class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        int sz = matches.size();
        map<int, int> win, loss;
        for(int i=0; i<sz; i++){
            win[matches[i][0]]++;
            loss[matches[i][1]]++;
        }
        vector<int> a, b;
        for(auto i : loss){
            if(i.second == 1) b.push_back(i.first);
        }
        for(auto i : win){
            if(loss.find(i.first) == loss.end()) a.push_back(i.first);
        }
        return {a, b};
    }
};