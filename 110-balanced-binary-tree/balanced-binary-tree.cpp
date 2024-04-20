class Solution {
public:
    int solve(TreeNode* root){
        if(!root) return 1;

        int left = solve(root->left);
        int right = solve(root->right);

        if(left == INT_MAX || right == INT_MAX) return INT_MAX;
        if(abs(left - right) <= 1) return 1 + max(left, right);
        return INT_MAX;
    }
    bool isBalanced(TreeNode* root) {
        return solve(root) != INT_MAX;
    }
};