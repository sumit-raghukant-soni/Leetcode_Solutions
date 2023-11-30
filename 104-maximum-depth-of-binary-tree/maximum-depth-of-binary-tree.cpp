/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void depth(TreeNode* root, int cnt, int& ans){
        if(root == NULL){
            ans = max(cnt, ans);
            return;
        }
        depth(root->left, cnt+1, ans);
        depth(root->right, cnt+1, ans);
    }
    int maxDepth(TreeNode* root) {
        int ans = 0;
        depth(root, 0, ans);
        return ans;
    }
};