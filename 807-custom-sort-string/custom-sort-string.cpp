class Solution {
public:
    string customSortString(string order, string s) {
        string ans = s;
        unordered_map<char, int> mp;
        int sz = order.size();

        for(int i=0; i<sz; i++){
            mp[order[i]] = i;
        }

        for(char ch = 'a'; ch <= 'z'; ch++){
            if(mp.find(ch) == mp.end()) mp[ch] = sz;
        }

        sort(ans.begin(), ans.end(), [&](char a, char b){
            return mp[a] < mp[b];
        });

        return ans;
    }
};