class BSTIterator {
public:
    TreeNode* root;
    stack<TreeNode*> st;
    unordered_map<int, int> mp;
    BSTIterator(TreeNode* r) {
        root = r;
        st.push(root);
    }
    
    int next() {
        if(st.size() == 0) return -1;
        TreeNode* front = st.top();
        while(front->left && mp.find(front->left->val) == mp.end()){
            st.push(front->left);
            front = front->left;
        }
        // cout << st.top()->val << " ";
        st.pop();
        if(front->right && mp.find(front->right->val) == mp.end()) st.push(front->right);
        mp[front->val]++;
        return front->val;
    }   
    
    bool hasNext() {
        return st.size();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */