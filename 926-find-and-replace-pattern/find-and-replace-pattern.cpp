class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> ans;
        string decodedpattern = "";
        int sz = words.size(), wsz = words[0].length(), psz = pattern.length();
        unordered_map<char, int> mp;
        int val = 0;
        for(int i=0; i<psz; i++){
            if(mp.find(pattern[i]) != mp.end()){
                decodedpattern += mp[pattern[i]];
            }
            else{
                decodedpattern += to_string(int(++val));
                mp[pattern[i]] = val;
            }
        }

        for(int i=0; i<sz; i++){
            mp.clear();
            int val = 0;
            string currPattern = "";
            for(int j=0; j<wsz; j++){
                if(mp.find(words[i][j]) != mp.end()){
                    currPattern += mp[words[i][j]];
                }
                else{
                    currPattern += to_string(int(++val));
                    mp[words[i][j]] = val;
                }
            }
            if(currPattern == decodedpattern) ans.push_back(words[i]);
        }

        return ans;
    }
};