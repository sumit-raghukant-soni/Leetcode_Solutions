class Solution {
public:
    int solve(TreeNode* root, int& ans) {
        if (!root) return 0;
        if (!root->left && !root->right) return 1;

        int left = solve(root->left, ans), right = solve(root->right, ans);

        ans = max(left+right, ans);

        // cout << root->val << " " << left << " " << right << endl;

        return max(left, right) + 1;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        int ans = 0;

        solve(root, ans);

        return ans;
    }
};