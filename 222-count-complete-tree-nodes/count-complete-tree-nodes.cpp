class Solution {
public:
    int countNodes(TreeNode* root) {
        if(!root) return 0;
        int cnt = 1 + countNodes(root->left) + countNodes(root->right);
        return cnt;        
    }
};