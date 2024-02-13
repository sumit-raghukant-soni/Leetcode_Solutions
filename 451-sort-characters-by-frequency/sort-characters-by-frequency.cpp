class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> mp;
        for(char ch : s) mp[ch]++;
        string ans = s;
        sort(ans.begin(), ans.end(), [&](char a, char b){
            if(mp[a] == mp[b]) return a > b;
            return mp[a] > mp[b];
        });
        return ans;
    }
};