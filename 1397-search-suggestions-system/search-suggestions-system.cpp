class TrieNode{
    public:
    bool isTerminal;
    vector<TrieNode*> childrens;
    TrieNode(){
        isTerminal = false;
        childrens = vector<TrieNode*>(26, NULL);
    }
};
class Trie{
    public:
    TrieNode* root;
    Trie(){
        root = new TrieNode();
    }

    void insert(string word){
        if(!root) root = new TrieNode();

        TrieNode* curr = root;
        int sz = word.length(), i=0;
        while(i < sz){
            int ind = word[i++] - 'a';
            if(!curr->childrens[ind]){
                curr->childrens[ind] = new TrieNode();
            }
            if(i == sz){
                curr->childrens[ind]->isTerminal = true;
                break;
            }
            curr = curr->childrens[ind];
        }
    }

    TrieNode* getRoot(TrieNode* root, string word){
        if(!root) return NULL;

        TrieNode* curr = root;
        int i = 0, sz = word.length();
        while(i < sz){
            int ind = word[i++] - 'a';
            if(!curr->childrens[ind]) return NULL;
            curr = curr->childrens[ind];
        }

        return curr;
    }
    void searchWord(string word, vector<string>& total){
        TrieNode* Root = getRoot(root, word);
        if(Root == NULL) return;
        if(Root->isTerminal) total.push_back(word);
        searchWordUtil(Root, total, word);
    }
    void searchWordUtil(TrieNode* root, vector<string>& total, string ans){
        if(total.size() >= 3) return;

        for(int i=0; i<26; i++){
            if(root->childrens[i]){
                if(root->childrens[i]->isTerminal && total.size() < 3) total.push_back(ans + char('a' + i));
                searchWordUtil(root->childrens[i], total, ans + char('a' + i));
            }
        }
    }
};

class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        Trie* t = new Trie();
        int sz = products.size(), sz2 = searchWord.length();
        for(int i=0; i<sz; i++){
            t->insert(products[i]);
        }
        vector<vector<string>> ans;

        for(int i=0; i<sz2; i++){
            vector<string> total;
            t->searchWord(searchWord.substr(0, i+1), total);
            ans.push_back(total);
        }

        return ans;      
    }
};