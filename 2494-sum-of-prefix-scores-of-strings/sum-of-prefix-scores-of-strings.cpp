class Solution {
public:
    class Trie{
        public:
        Trie *childs[26];
        int score;
        Trie(){
            // childs = vector<Trie*>(26, NULL);
            for(int i=0; i<26; i++) childs[i] = NULL;
            score = 0;
        }
    };

    // void insertString(Trie* t, string& word, int& sz, int i){
    //     if(i == sz) return;

    //     if(!t->childs[word[i]-'a']) t->childs[word[i]-'a'] = new Trie();
    //     t->childs[word[i]-'a']->score++;
    //     insertString(t->childs[word[i]-'a'], word, sz, i+1);
    // }

    // int getScore(Trie* t, string& word, int& sz, int i){
    //     if(i == sz) return 0;
    //     return t->childs[word[i]-'a']->score + getScore(t->childs[word[i]-'a'], word, sz, i+1);
    // }

    vector<int> sumPrefixScores(vector<string>& words) {
        int sz = words.size();
        vector<int> ans(sz);
        Trie *t = new Trie(), *curr = NULL;
        int sz2;

        for(int i=0; i<sz; i++){
            sz2 = words[i].length();
            // insertString(t, words[i], sz2, 0);
            curr = t;
            for(int j=0; j<sz2; j++){
                if(!curr->childs[words[i][j]-'a']) curr->childs[words[i][j]-'a'] = new Trie();
                curr->childs[words[i][j]-'a']->score++;
                curr = curr->childs[words[i][j]-'a'];
            }
        }

        for(int i=0; i<sz; i++){
            sz2 = words[i].length();
            curr = t;
            // ans[i] = getString(t, words[i], sz2, 0);
            for(int j=0; j<sz2; j++){
                ans[i] += curr->childs[words[i][j]-'a']->score;
                curr = curr->childs[words[i][j]-'a'];
            }
        }

        return ans;
    }
};