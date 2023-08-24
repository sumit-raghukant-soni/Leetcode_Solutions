class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        multiset<int, greater<int>> st(stones.begin(), stones.end());
        
        while(st.size() > 1){
            int y = *(st.begin());
            st.erase(st.begin());
            int x = *(st.begin());
            st.erase(st.begin());
            if(x < y)
                st.insert(y-x);
        }
    
        return st.size() == 0 ? 0 : *(st.begin());
    }
};