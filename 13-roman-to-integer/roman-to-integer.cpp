class Solution {
public:
    int romanToInt(string s) {
        int ans = 0, sz = s.length();
        unordered_map<int, int> mp = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        for(int i=0; i<sz; i++){
            if(i+1 < sz && mp[s[i]] < mp[s[i+1]]){
                ans -= mp[s[i]];
            }
            else ans += mp[s[i]];
        }

        return ans;
    }
};