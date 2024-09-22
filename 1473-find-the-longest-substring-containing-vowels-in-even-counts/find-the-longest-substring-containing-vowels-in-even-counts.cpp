class Solution {
public:
    int getMax(string& s, int& sz, vector<int> cnt){
        int i=0;

        while(i <= sz && cnt[0]&1 || cnt[4]&1 || cnt[8]&1 || cnt[14]&1 || cnt[20]&1){
            cnt[s[i] - 'a']--;
            i++;
        }
        return sz - i + 1;
    }
    int findTheLongestSubstring(string s) {
        int sz = s.length(), ans = 0;
        vector<int> cnt(26, 0);
        string tmp = "";

        for(int i=0; i<sz; i++){
            tmp += s[i];
            cnt[s[i] - 'a']++;
            ans = max(ans, getMax(tmp, i, cnt));
        }

        return ans;
    }
};