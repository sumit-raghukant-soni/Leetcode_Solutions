class Node{
    Node *links[2];
public:
    bool ContainsKey(int bit) { return links[bit] != NULL; }
    Node *get(int bit) { return links[bit]; }
    void put(int bit, Node *node) { links[bit] = node; }
};

class Trie{
    Node *root;
public:
    Trie() { root = new Node(); }

    void insert(int num){
        Node *node = root;
        for (int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if (!(node->ContainsKey(bit))){
                node->put(bit, new Node());
            }
            node = node->get(bit);
        }
    }

    int maxXor(int num){
        Node *node = root;
        int maxx = 0; 
        for (int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if (node->ContainsKey(1 - bit)){
                maxx = maxx | (1 << i);    
                node = node->get(1 - bit); 
            }
            else node = node->get(bit);
        }
        return maxx;
    }
};

class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        Trie trie;
        int maxx=0;

        for(auto &it:nums)
            trie.insert(it);

        for(auto &it:nums)
            maxx=max(maxx,trie.maxXor(it));

        return maxx;
    }
};