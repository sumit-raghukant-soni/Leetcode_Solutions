/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(root == NULL) return {};
        queue<Node*> q;
        vector<vector<int>> ans;
        vector<int> tmp;
        q.push(root);
        q.push(NULL);
        while(!q.empty()){
            Node* front = q.front();
            q.pop();
            if(front == NULL){
                if(!q.empty()){
                    front = q.front();
                    q.pop();
                    q.push(NULL);
                    ans.push_back(tmp);
                    tmp.clear();
                }
                else break;
            }
            tmp.push_back(front->val);
            for(auto i : front->children){
                q.push(i);
            }
        }
        ans.push_back(tmp);
        return ans;
    }
};