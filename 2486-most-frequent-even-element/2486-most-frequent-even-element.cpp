class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        set<pair<int, int>> st;
        map<int, int> mp;

        for(auto i : nums) mp[i]++;
        for(auto i : mp) st.insert({i.second, i.first});
        
        int ele = INT_MAX, cnt = 0;
        while(!st.empty()){
            int element = st.rbegin()->second;
            int freq = st.rbegin()->first;
            if((element&1) == 0 && cnt <= freq && element < ele){
                ele = element, cnt = freq;
            }
            st.erase(*st.rbegin());
        }
        if(ele == INT_MAX) return -1;
        return ele;
    }
};