/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    void solve(Node* node, Node* &root, unordered_map<int, Node*>& mp, unordered_map<int, int>& vis){
        if(!node || vis[node->val]) return;
        vis[node->val]++;
        for(int i=0; i<node->neighbors.size(); i++){
            if(mp.find(node->neighbors[i]->val) == mp.end()){
                Node* tmp = new Node(node->neighbors[i]->val);
                mp[tmp->val] = tmp;
                root->neighbors.push_back(tmp);
            }
            else{
                root->neighbors.push_back(mp[node->neighbors[i]->val]);
            }
            solve(node->neighbors[i], root->neighbors[i], mp, vis);
        }
    }
    Node* cloneGraph(Node* node) {
        if(!node) return NULL;
        Node* root = new Node(node->val);
        unordered_map<int, Node*> mp;
        unordered_map<int, int> vis;
        mp[node->val] = root;

        solve(node, root, mp, vis);

        return root;
    }
};