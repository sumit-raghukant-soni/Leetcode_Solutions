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
    vector<int> postorder(Node* root) {
        vector<int> ans;
        if(!root) return ans;

        stack<Node*> st;
        st.push(root);
        while(!st.empty()){
            Node* front = st.top();
            st.pop();
            for(int i=0; i<front->children.size(); i++){
                st.push(front->children[i]);
            }
            ans.insert(ans.begin(), front->val);
        }

        return ans;
    }
};