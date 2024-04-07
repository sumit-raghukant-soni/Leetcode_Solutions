class Solution {
public:
    string getSmallestString(string s, int k) {
        string ans = "";
        int sz = s.length();

        for(int i=0; i<sz; i++){
            int offset = s[i] - 'a';
            if(offset <= 26 - offset){
                int delta = min(k, offset);
                ans += char(s[i] - delta);
                k -= delta;
            }
            else if(k >= 26 - offset){
                ans += 'a';
                k -= min(k, 26 - offset);
            }
            else{
                int delta = min(k, 26-offset);
                ans += char(s[i] - delta);
                k -= delta;
            }
        }

        return ans;
    }
};