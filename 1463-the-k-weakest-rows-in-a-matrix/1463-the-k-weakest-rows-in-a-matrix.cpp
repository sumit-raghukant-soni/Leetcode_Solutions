class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        set<pair<int, int>> st;

        for(int i=0; i<mat.size(); i++){
            int cnt = 0;
            for(int j=0; j<mat[0].size(); j++){
                cnt += (mat[i][j] == 1);
            }
            st.insert({cnt, i});
        }
        vector<int> ans;
        for(int i=0; i<k; i++){
            ans.push_back(st.begin()->second);
            st.erase(st.begin());
        }
        return ans;
    }
};