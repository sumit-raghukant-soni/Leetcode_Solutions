class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int sz = score.size();
        vector<string> ans(sz);

        set<int, greater<int>> mp;

        for(int i=0; i<sz; i++){
            mp.insert(score[i]);
        }

        transform(score.begin(), score.end(), ans.begin(), [](int a) { return to_string(a); });

        for(int i=0; i<sz; i++){
            int rank = distance(mp.begin(), mp.find(score[i]));
            ans[i] = to_string(rank+1);
            if(rank == 0) ans[i] = "Gold Medal";
            if(rank == 1) ans[i] = "Silver Medal";
            if(rank == 2) ans[i] = "Bronze Medal";
        }

        return ans;   
    }
};