class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        int sz = skill.size(), n = sz;
        long long ans = 0;
        unordered_map<int, int> mp;

        for(int i : skill) mp[i]++;
        
        sort(skill.begin(), skill.end());

        int pSum = skill[0] + skill[sz-1];

        for(int i=0; i<(sz/2); i++){
            int second = pSum-skill[i];
            mp[skill[i]]--;
            if(mp.find(second) != mp.end() && mp[second] != 0){
                mp[second]--;
                ans += 1LL * skill[i] * second;
            }
            else return -1;
        }

        return ans;
    }
};