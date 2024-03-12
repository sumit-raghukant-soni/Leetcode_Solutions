class Node {
    public:
    bool isTerminated;
    Node* childrens[26];
    Node(){
        isTerminated = false;
        for(int i=0; i<26; i++) childrens[i] = NULL;
    }
};

class WordDictionary {
public:
    Node* root;
    WordDictionary() {
        root = new Node();
    }
    
    void addWord(string word) {
        int sz = word.length();
        Node* curr = root;
        for(int i=0; i<sz; i++){
            if(curr->childrens[word[i] - 'a'] == NULL){
                curr->childrens[word[i] - 'a'] = new Node();
            }
            curr = curr->childrens[word[i] - 'a'];
        }
        curr->isTerminated = true;
    }
    
    bool search(string word) {
        Node* curr = root;
        return search2(curr, word, word.length(), 0);
    }

    bool search2(Node* curr, string word, int sz, int ind) {
        if(!curr) return false;
        // cout << word[ind] << " ";
        if(sz == ind+1){
            // cout << "returned " << endl;
            if(word[ind] == '.'){
                for(int i=0; i<26; i++) if(curr->childrens[i] != NULL && curr->childrens[i]->isTerminated == true) return true;
                return false;
            }
            else if(curr->childrens[word[ind] - 'a'] == NULL || curr->childrens[word[ind] - 'a']->isTerminated == false) return false;
            // cout << " endl" << endl;
            return true;
        }
        // cout << word[ind] << endl;
        if(word[ind] == '.'){
            for(int i=0; i<26; i++){
                if(curr->childrens[i] != NULL && search2(curr->childrens[i], word, sz, ind+1)) return true; 
            }
            return false;
        }
        else if(curr->childrens[word[ind] - 'a'] == NULL) return false;
        return search2(curr->childrens[word[ind] - 'a'], word, sz, ind+1);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */