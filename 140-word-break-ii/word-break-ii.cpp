class Solution {
public:
    vector<string> ans; 
    vector<vector<string>> paths;
    void solve(string s, unordered_set<string>& dict, vector<string> tmp){
        if(s.length() == 0){
            paths.push_back(tmp);
            return;
        }

        int sz = s.length();
        string word = "";
        for(int i=0; i<sz; i++){
            word += s[i];
            if(dict.find(word) != dict.end()){
                tmp.push_back(word);
                solve(s.substr(i+1), dict, tmp);
                tmp.pop_back();
            }
        }
    }
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict(wordDict.begin(), wordDict.end());

        solve(s, dict, {});

        for(vector<string> path : paths){
            string sentence = "";
            for(string word : path){
                if(sentence != "") sentence += " ";
                sentence += word;
            }
            ans.push_back(sentence);
        }

        return ans;
    }
};