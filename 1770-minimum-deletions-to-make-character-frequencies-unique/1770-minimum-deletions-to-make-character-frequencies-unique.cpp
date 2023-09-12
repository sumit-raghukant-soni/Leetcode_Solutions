class Solution {
public:
    int minDeletions(string s) {
        multiset<int, greater<int>> st;
        map<char, int> mp;
        int cnt = 0;
        for(auto i : s)
            mp[i]++;
        
        for(auto i : mp)
            st.insert(i.second);

        while(!st.empty()){
            int ntop = *st.begin();
            st.erase(st.begin());
            if(ntop == *st.begin() && ntop != 0){
                st.insert(*st.begin()-1);
                cnt++;
            }
        }
        return cnt;
    }
};