class Solution {
public:
    void solve(TreeNode* root, TreeNode* &prev){
        if(!root) return;
        
        TreeNode *left = root->left, *right = root->right;

        if(prev == NULL) prev = root;
        else { prev->right = root; prev->left = NULL; prev = root; }
        
        if(left) solve(left, prev);
        if(right) solve(right, prev);
    }
    void flatten(TreeNode* root) {
        if(!root) return;
        TreeNode* prev = NULL;
        solve(root, prev);
    }
};