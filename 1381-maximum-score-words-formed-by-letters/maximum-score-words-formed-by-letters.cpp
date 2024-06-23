class Solution {
public:
    unordered_map<char , int> lettersList;
    int canFormWord(unordered_map<char, int> lettersList, string word){
        int sz = word.length();

        for(int i=0; i<sz; i++){
            if(lettersList[word[i]] == 0) return false;
            lettersList[word[i]]--;
        }

        return true;
    }

    int getScore(string word, vector<int>& score){
        int ans = 0, sz = word.length();

        for(int i=0; i<sz; i++){
            ans += score[word[i] - 'a'];
        }

        return ans;
    }

    int solve(int i, int wsz, vector<string>& words, vector<int>& score){
        cout << i << endl;
        if(i == wsz) return 0;

        int mxScore = solve(i+1, wsz, words, score);
        if(canFormWord(lettersList, words[i])){
            // cout << words[i] << " can be formed" << endl;
            for(char ch : words[i]) lettersList[ch]--;
            mxScore = max(mxScore, getScore(words[i], score) + solve(i+1, wsz, words, score));
            for(char ch : words[i]) lettersList[ch]++;
        }
        // cout << words[i] << mxScore << endl;
        return mxScore;
    }

    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        int sz = letters.size(), wsz = words.size();
        for(int i=0; i<sz; i++) lettersList[letters[i]]++;

        return solve(0, wsz, words, score);
    }
};