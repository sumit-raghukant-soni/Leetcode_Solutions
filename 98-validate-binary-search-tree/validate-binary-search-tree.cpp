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
    bool checkBST(TreeNode* root, long mini, long maxi) {
        if (!root) return true;

        bool isValid = root->val > mini && root->val < maxi;
        
        if(!isValid) return false;
        return checkBST(root->left, mini, root->val) && checkBST(root->right, root->val, maxi);
    }
    bool isValidBST(TreeNode* root) { 
        return checkBST(root, 1LL*INT_MIN-1, 1LL*INT_MAX+1); 
    }
};