class Solution {
public:
    bool check(string& s, map<string, int>& mp, int sz, int& wSz, int ind){
        map<string, int> mp2;
        // cout << ind << " " << sz << " start" << endl;
        for(int i=ind; i<ind+sz; i+=wSz){
            // cout << s.substr(i, wSz) << " ";
            mp2[s.substr(i, wSz)]++;
        }
        // for(auto i : mp2) cout << i.first << " ";
        // cout << endl;
        return mp == mp2;
    }
    vector<int> findSubstring(string s, vector<string>& words) {
        int sz = s.length(), sz2 = words.size(), wSz = words[0].size();
        vector<int> ans;

        map<string, int> mp;
        for(string i : words) mp[i]++;

        for(int i=0; i<=sz - (wSz*sz2); i++){
            bool ch = check(s, mp, sz2 * wSz, wSz, i);
            // cout << s[i] << " " << (ch ? "Yes" : "No") << endl;
            if(ch) ans.push_back(i);
        }


        return ans;
    }
};