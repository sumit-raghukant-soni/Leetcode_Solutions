class Solution {
public:
    void solve(TreeNode* root, int targetSum, bool& ans){
        if(!root || ans == true) return;
        if(targetSum == root->val && !root->left && !root->right){ ans = true; return; }

        solve(root->left, targetSum-root->val, ans);
        solve(root->right, targetSum-root->val, ans);
    }
    bool hasPathSum(TreeNode* root, int targetSum) {
        bool ans = false;
        solve(root, targetSum, ans);        
        return ans;
    }
};