class Node {
    public:
    bool Terminated;
    Node* childrens[26]; 
    Node() {
        Terminated = false;
        for(int i=0; i<26; i++) childrens[i] = NULL;
    }
};

class Trie {
public:
    Node* root;
    Trie() {
        root = new Node();
    }
    
    void insert(string word) {
        int sz = word.length();
        Node* curr = root;
        for(int i=0; i<sz; i++){
            if(curr->childrens[word[i] - 'a'] == NULL){
                curr->childrens[word[i] - 'a'] = new Node();
            }
            curr = curr->childrens[word[i] - 'a'];
        }
        curr->Terminated = true;
    }
    
    bool search(string word) {
        int sz = word.length();
        Node* curr = root;
        for(int i=0; i<sz; i++){
            if(curr->childrens[word[i] - 'a'] == NULL) return false;
            curr = curr->childrens[word[i] - 'a'];
        }
        return curr->Terminated;
    }
    
    bool startsWith(string prefix) {
        int sz = prefix.length();
        Node* curr = root;
        for(int i=0; i<sz; i++){
            if(curr->childrens[prefix[i] - 'a'] == NULL) return false;
            curr = curr->childrens[prefix[i] - 'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */