class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        vector<int> tmp(m);
        for(int i=1; i<=m; i++)
            tmp[i-1] = i;
        
        int sz = queries.size();
        vector<int> ans(sz);

        for(int i=0; i<sz; i++){
            int t = queries[i];
            int ind = find(tmp.begin(), tmp.end(), t) - tmp.begin();
            ans[i] = ind;
            tmp.insert(tmp.begin(), tmp[ind]);
            tmp.erase(tmp.begin()+ind+1);
        }

        return ans;
    }
};