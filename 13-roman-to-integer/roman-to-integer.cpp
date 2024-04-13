class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> mp = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        int ans = 0, sz = s.length();

        for(int i=sz-1; i>=0; i--){
            ans += mp[s[i]];
            int j = i - 1;
            while(j >= 0 && mp[s[i]] > mp[s[j]]){
                ans -= mp[s[j--]];
            }
            if(j != i-1) i = j+1;
        }

        return ans;
    }
};