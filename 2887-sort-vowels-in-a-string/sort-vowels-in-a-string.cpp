class Solution {
public:
    string sortVowels(string s) {
        vector<int> Eindex;
        unordered_map<int, bool> mp;
        int sz = s.length();
        for(int i=0; i<sz; i++){
            char tmp = tolower(s[i]);
            if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u'){
                mp[i] = true;
                Eindex.push_back(i);
            } 
        }

        sort(Eindex.begin(), Eindex.end(), [&](int a, int b){
            return s[a] < s[b];
        });

        string ans = "";
        int ind = 0;
        for(int i=0; i<sz; i++){
            if(mp.find(i) != mp.end()){
                ans += s[Eindex[ind++]];
            }
            else ans += s[i];
        }

        return ans;
    }
};