class Solution {
public:
    unordered_map<string, int> dp;
    int solve(string s, unordered_map<string, int>& words){
        if(s.length() == 0){
            return  true;
        }

        if(dp.find(s) != dp.end()) return dp[s];

        string tmp = "";
        for(int ind = 0; ind < s.length(); ind++){
            tmp += s[ind];
            if(words.find(tmp) != words.end() && solve(s.substr(ind+1), words)){
                return dp[tmp] = true;
            }
        }
        return dp[s] = false;
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_map<string, int> words;

        for(string str : wordDict) words[str]++;

        return solve(s, words);
    }
};