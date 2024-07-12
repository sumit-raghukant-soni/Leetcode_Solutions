class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int sz = s.length();
        string tmp = "";
        vector<string> ans;
        unordered_map<string, int> mp;

        for(int i=0; i<sz; i++){
            if(i<=9) tmp += s[i];
            else {
                mp[tmp]++;
                tmp.erase(0, 1);
                tmp += s[i];
            }
        }

        mp[tmp]++;

        for(auto i : mp){
            if(i.second > 1) ans.push_back(i.first);
        }

        return ans;
    }
};