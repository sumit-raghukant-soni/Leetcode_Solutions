/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* getFlattened(TreeNode* root) {
        if(!root) return NULL;
        if(!root->left && !root->right) return root;

        TreeNode* next = root->right;

        root->right = getFlattened(root->left);
        root->left = NULL;

        TreeNode* curr = root;
        while (curr->right)
            curr = curr->right;

        curr->right = next;
        
        curr->right = getFlattened(curr->right);

        return root;
    }
    void flatten(TreeNode* root) {
        getFlattened(root);
    }
};