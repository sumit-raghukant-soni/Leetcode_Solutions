class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int mp[26] = {0}, maxFreq = 0;
        for (char ch : tasks){
            mp[ch - 'A']++;
            maxFreq = max(maxFreq, mp[ch - 'A']);
        }
        
        maxFreq--;
        int ans = maxFreq * n, flg = 0;

        for(int i=0; i<26; i++){
            if(mp[i] != (maxFreq+1) || flg){
                ans -= min(maxFreq, mp[i]);
            }
            else flg++;
        }

        return tasks.size() + (ans < 0 ? 0 : ans);
    }
};