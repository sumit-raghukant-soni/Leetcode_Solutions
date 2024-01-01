class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        multiset<int> st(s.begin(), s.end());
        int cnt = 0;

        for(auto i : g){
            while(st.size() && *st.begin() < i) st.erase(st.begin());
            if(st.size() && *st.begin() >= i){
                st.erase(st.begin());
                cnt++;
            }
        }

        return cnt;
    }
};