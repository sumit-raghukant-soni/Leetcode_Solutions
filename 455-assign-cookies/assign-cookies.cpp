class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int cnt = 0, ind = 0, sz = s.size();

        for(auto i : g){
            while(ind < sz && s[ind] < i) ind++;
            if(ind < sz && s[ind] >= i){
                ind++;
                cnt++;
            }
        }

        return cnt;
    }
};