class Solution {
public:
    void solve(TreeNode* root, int& ans, int dir, int tmp){
        if(!root) return;
        ans = max(ans, tmp);
        
        if(!root->left && !root->right) return;

        solve(root->left, ans, 1, dir ? 1 : tmp + 1);
        solve(root->right, ans, 0, dir ? tmp + 1 : 1);
    }
    int longestZigZag(TreeNode* root) {
        if(!root) return 0;
        
        int ans = 0;
        solve(root, ans, 0, 0);

        return ans;
    }
};