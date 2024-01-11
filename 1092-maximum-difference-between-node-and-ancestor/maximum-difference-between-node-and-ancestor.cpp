class Solution {
public:
    void solve(TreeNode* root, int maxi, int mini, int& ans){
        if(!root) return;
        ans = max({ans, abs(maxi - root->val), abs(mini - root->val)});
        maxi = max(root->val, maxi);
        mini = min(root->val, mini);
        solve(root->left, maxi, mini, ans);
        solve(root->right, maxi, mini, ans);
    }
    int maxAncestorDiff(TreeNode* root) {
        int ans = 0;

        solve(root->left, root->val, root->val, ans);
        solve(root->right, root->val, root->val, ans);

        return ans;
    }
};