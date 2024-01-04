class Solution {
public:
    void print(set<pair<int, int>> mp){
        for(auto i : mp){
            cout << i.first << " " << i.second << endl;
        }
        cout << endl;
    }
    int minOperations(vector<int>& nums) {
        set<pair<int, int>> st;
        unordered_map<int, int> mp;
        int cnt = 0;
        for(auto i : nums) mp[i]++;

        for(auto i : mp) st.insert({i.second, i.first});

        while(!st.empty() && st.rbegin()->first > 1){
            int freq = st.rbegin()->first, val = st.rbegin()->second;
            st.erase({freq, val});
            if(freq > 2){
                cnt += freq/3;
                if(freq%3) cnt++;
            }
            else if(freq >= 2) cnt += freq/2;
            else return -1;
        }

        return st.empty() ? cnt : -1;
    }
};