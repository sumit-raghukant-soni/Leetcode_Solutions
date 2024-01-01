class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int cnt = 0, ind = 0, sz = s.size(), sz2 = g.size();

        for(int i=0; i<sz; i++){
            while(ind < sz2 && i < sz && s[i] < g[ind]) i++;
            if(ind < sz2 && i < sz && s[i] >= g[ind]){
                ind++;
                cnt++;
            }
        }

        return cnt;
    }
};