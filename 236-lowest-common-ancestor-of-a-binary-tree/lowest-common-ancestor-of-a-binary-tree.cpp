class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL) return NULL;

        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);

        if(((root == p || root == q) && (left || right)) || left && right)
            return root;
        
        if(root == p || root == q) return root;
        return left ? left : right;
    }
};