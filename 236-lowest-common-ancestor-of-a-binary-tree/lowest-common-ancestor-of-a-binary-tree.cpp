/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* solve(TreeNode* root, TreeNode* p, TreeNode* q, TreeNode* &ans){
        if(!root || ans) return NULL;

        TreeNode *left = solve(root->left, p, q, ans), *right = solve(root->right, p, q, ans);
        if(root->val == p->val){
            if(left == q || right == q) ans = root;
            return p;
        } 
        if(root->val == q->val){
            if(left == p || right == p) ans = root;
            return q;
        } 

        if(left && right) ans = root;

        return !right ? left : right;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* ans = NULL;

        solve(root, p, q, ans);

        return ans;
    }
};