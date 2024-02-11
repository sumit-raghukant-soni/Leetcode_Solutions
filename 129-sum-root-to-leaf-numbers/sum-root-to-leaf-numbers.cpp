class Solution {
public:
    void solve(TreeNode* root, int tmp, int& ans){
        if(!root) return;
        tmp = (tmp*10) + root->val;
        if(!root->left && !root->right){
            ans += tmp;
            return;
        }
        solve(root->left, tmp, ans);
        solve(root->right, tmp, ans);
    }
    int sumNumbers(TreeNode* root) {
        int ans = 0;

        solve(root, 0, ans);

        return ans;
    }
};