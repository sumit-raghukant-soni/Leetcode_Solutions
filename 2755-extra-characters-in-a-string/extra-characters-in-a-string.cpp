class Solution {
public:
    void solve(string& s, int& sz, unordered_map<string, int>& mp, int& ans, int value, int i){
        if(ans == 0) return;
        if(i == sz){
            ans = min(ans, value);
            return;
        }

        string str = "";
        for(int j=i; j<sz; j++){
            str += s[j];
            if(mp.find(str) != mp.end()){
                solve(s, sz, mp, ans, value, j+1);
            }
            else if(str.length() == 1) solve(s, sz, mp, ans, value+1, j+1);
        }
    }
    int minExtraChar(string s, vector<string>& dictionary) {
        int sz = s.length(), ans = sz;
        unordered_map<string, int> mp;
        for(string str : dictionary){
            mp[str]++;
        }

        solve(s, sz, mp, ans, 0, 0);

        return ans;
    }
};