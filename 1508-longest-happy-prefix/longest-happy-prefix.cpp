class Solution {
public:
    string longestPrefix(string s) {
        int sz = s.length();
        vector<int> lps(sz);
        int j=0;

        for(int i=1; i<sz; i++){
            while(j > 0 && s[i] != s[j]){
                j = lps[j-1];
            }

            if(s[i] == s[j]){
                lps[i] = j+1;
                j += 1;
            }
        }

        // for(int i : lps) cout << i << " ";

        return s.substr(0, lps[sz-1]);
    }
};