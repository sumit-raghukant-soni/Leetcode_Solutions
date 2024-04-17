class Solution {
public:
    void morrisTraversalPreorder(TreeNode* root, vector<int>& ans) {
        while (root) {
            if (root->left == NULL) {
                ans.push_back(root->val);
                root = root->right;
            } 
            else {
                TreeNode* current = root->left;
                while (current->right && current->right != root)
                    current = current->right;

                if (current->right == root) {
                    current->right = NULL;
                    root = root->right;
                } else {
                    ans.push_back(root->val);
                    current->right = root;
                    root = root->left;
                }
            }
        }
    }
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;

        morrisTraversalPreorder(root, ans);

        return ans;
    }
};