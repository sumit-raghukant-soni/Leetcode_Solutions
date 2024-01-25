class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map<char, string> mp1;
        unordered_map<string, char> mp2;

        int sz = s.length(), sz2 = pattern.length();
        string t = "";
        vector<string> tmp;

        for(int i=0; i<sz; i++){
            if(s[i] != ' ') t += s[i];
            if(s[i] == ' ' || i == sz-1){
                if(t != "") tmp.push_back(t);
                t = "";
            }
        }

        if(sz2 != tmp.size()) return false;

        for(int i=0; i<sz2; i++){
            // cout << tmp[i] << " " << pattern[i] << endl;
            if(mp1.find(pattern[i]) != mp1.end() || mp2.find(tmp[i]) != mp2.end()){
                // cout << mp1[pattern[i]] << "!=" << tmp[i] << " " << mp2[tmp[i]] << "!=" << pattern[i] << endl;
                if(mp1[pattern[i]] != tmp[i] || mp2[tmp[i]] != pattern[i]) return false;
            }
            else{
                mp1[pattern[i]] = tmp[i];
                mp2[tmp[i]] = pattern[i];
            }
        }

        return true;
    }
};