class Solution {
public:
    int countCompleteDayPairs(vector<int>& hours) {
        int sz = hours.size(), ans = 0;
        unordered_map<int, int> mp;

        for(int i=0; i<sz; i++){
            ans += mp[(24 - (hours[i]%24))%24];
            mp[hours[i]%24]++;
        }

        return ans;
    }
};