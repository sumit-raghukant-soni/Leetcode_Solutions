class Solution {
public:
    void getLeaves(TreeNode* root, vector<int>& tmp){
        if(!root) return;

        if(!root->left && !root->right) tmp.push_back(root->val);
        getLeaves(root->left, tmp);
        getLeaves(root->right, tmp);
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> a, b;
        getLeaves(root1, a);
        getLeaves(root2, b);
        return a == b;
    }
};