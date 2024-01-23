class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int sz = s.length(), ans = 0, start = 0;
        unordered_map<char, int> alpha;
        for(int i=0; i<sz; i++){
            alpha[s[i]]++;
            if(alpha[s[i]] > 1){
                while(start <= i && s[start] != s[i]){
                    // cout << "removed " << s[start] << endl;
                    alpha[s[start]]--;
                    start++;
                }
                // cout << "removed" << s[start] << endl;
                alpha[s[start]]--;
                start++;
            }
            ans = max(ans, i-start+1);
            // cout << i << " " << ans << " " << start << endl;
        }

        return ans;
    }
};