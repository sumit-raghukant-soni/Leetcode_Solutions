class Solution {
public:
    string decodeMessage(string key, string message) {
        string ans = "";
        map<char, char> mp;
        int ind = 0;

        for(int i=0; i<key.length(); i++){
            if(key[i] != ' ' && mp.find(key[i]) == mp.end())
                mp[key[i]] = char(ind++ + 'a');
        }
        
        for(auto i : message){
            if(i != ' ') ans += mp[i];
            else ans += ' ';
        }
        return ans;
    }
};